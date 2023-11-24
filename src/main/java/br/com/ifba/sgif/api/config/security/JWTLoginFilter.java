package br.com.ifba.sgif.api.config.security;

import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import br.com.ifba.sgif.api.infrastructure.service.JWTTokenAuthenticationService;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    // =========================================================== //
    // =============== [         MÉTODOS      ] ================== //
    // =========================================================== //

    /**
     * Adiciona filtro de login.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param url A url da requisição.
     * @param authenticationManager O gerenciador de autenticação.
     */
    public JWTLoginFilter(String url, AuthenticationManager authenticationManager){

        super(new AntPathRequestMatcher(url));

        setAuthenticationManager(authenticationManager);

    }

    /**
     * Faz uma tentativa de autenticação.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param request A requisição http.
     * @param response A resposta da requisição http.
     * @return uma instância da autenticação do usuário.
     * @throws AuthenticationException caso haja erro de autenticação.
     * @throws IOException caso haja um recurso não encontrado.
     * @throws ServletException caso haja um erro de servlet.
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        Usuario user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);


        return new UsernamePasswordAuthenticationToken(
                user.getLogin(),
                user.getSenha()
        );

    }

    /**
     * Conclui a autenticação com sucesso.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param request A requisição http.
     * @param response A resposta da requisição http.
     * @param chain A cadeia de filtros.
     * @param authResult O resultado da tentativa de autorização.
     * @throws IOException caso haja algum recurso não encontrado.
     * @throws ServletException caso haja algum erro de servlet.
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        try {
            new JWTTokenAuthenticationService().addAuthorization(response, authResult.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
