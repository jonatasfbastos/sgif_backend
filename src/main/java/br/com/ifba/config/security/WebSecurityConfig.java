package br.com.ifba.config.security;

import br.com.ifba.ApplicationContextLoad;
import br.com.ifba.infrastructure.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSessionListener;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer, HttpSessionListener {


    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Configura construtor de gerenciador de autenticação.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param auth O construtor de gerenciador de autenticação.
     * @throws Exception caso haja algum erro na configuração.
     */
    @Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    /**
     * Cofigura segurança da aplicação.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param http O objeto http.
     * @return configurações da cadeia de segurança.
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        // TODO: Rever privacidade de endpoints POST.

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .disable()
                .authorizeRequests((auth) -> {
                    auth.antMatchers(HttpMethod.GET).permitAll();
                    auth.antMatchers(HttpMethod.POST, "/apif/v1/usuarios/usuario").permitAll();
                    auth.antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    auth.anyRequest().authenticated();

                    // Configuração de Logout.
                    try {

                        auth.and().logout().logoutSuccessUrl("PATH_TO_LOGOUT_SCREEN");
                        auth.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    // Configuração de JWT.

                    try {

                        // TODO: Resolver erro no authenticationManager().
                        auth.and().addFilterAfter(new JWTLoginFilter(
                                "/login",
                                        ApplicationContextLoad.getApplicationContext().getBean(AuthenticationManager.class)),
                                UsernamePasswordAuthenticationFilter.class
                        );

                        auth.and().addFilterBefore(new JWTApiAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                });

        return http.build();

    }

    /**
     * Define configurações de CORS.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param registry O registro de CORS.
     * @return registro com cabeçalhos e rotas autorizadas.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }

}
