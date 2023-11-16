package br.com.ifba.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {


    // TODO: Limpar essa classe
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeHttpRequests((auth) ->
                auth.antMatchers(HttpMethod.GET)
                .permitAll()
                .antMatchers(HttpMethod.POST, "/apif/v1/login").permitAll()
                .anyRequest().authenticated());

        return http.build();

    }
    /**
     * Define filtros da cadeia de segurança.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param http O objeto http.
     * @return configurações da cadeia de segurança.
     */
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        // TODO:Rever privacidade de alguns endpoints.

        return http.csrf()
                    .disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET) // Todos os métodos GET estão públicos
                    .permitAll()
                .antMatchers(HttpMethod.POST, "/apif/v1/login")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
                .build();
    }*/

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

    /**
     * Define o gerente de autenticação
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param authenticationConfiguration Objeto de configurações de autenticação.
     * @return o gerente de autenticação da aplicação.
     */
    @Bean
    public AuthenticationManager
    authenticationConfiguration(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Define encoder de senhas.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @return encoder de senha.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }


}
