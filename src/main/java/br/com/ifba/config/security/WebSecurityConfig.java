package br.com.ifba.config.security;

import br.com.ifba.infrastructure.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSessionListener;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig implements WebMvcConfigurer, HttpSessionListener {


    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private AuthenticationConfiguration configuration;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // =========================================================== //
    // =============== [         MÉTODOS      ] ================== //
    // =========================================================== //

    /**
     * Configura construtor de gerenciador de autenticação.
     *
     * @param auth O construtor de gerenciador de autenticação.
     * @throws Exception caso haja algum erro na configuração.
     * @author Giovane Neves
     * @since Desde V1.0.1
     */
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
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
    public SecurityFilterChain web(HttpSecurity http) throws Exception {

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

                        auth.and().logout().logoutSuccessUrl("/index");
                        auth.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    // Configuração de JWT.

                    try {

                        auth.and().addFilterAfter(
                                new JWTLoginFilter(
                                        "/login",
                                        configuration.getAuthenticationManager()
                                ),
                                UsernamePasswordAuthenticationFilter.class
                        );

                        auth.and().addFilterBefore(new JWTApiAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                })
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

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
