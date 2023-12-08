package br.com.ifba.sgif.api.config.security;

import br.com.ifba.sgif.api.infrastructure.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSessionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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


    @Bean
    public FilterRegistrationBean processCorsFilter() {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("file:///C:/Users/giova/Downloads/requesttt/index.html"));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/login", config);
        source.registerCorsConfiguration("/apif/**", config);
        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
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
                    auth.antMatchers(HttpMethod.POST, "/apif/v1/login").permitAll();
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
