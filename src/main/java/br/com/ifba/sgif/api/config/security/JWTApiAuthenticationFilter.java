package br.com.ifba.sgif.api.config.security;

import br.com.ifba.sgif.api.infrastructure.service.JWTTokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
public class JWTApiAuthenticationFilter extends GenericFilterBean {

    // =========================================================== //
    // =============== [         MÉTODOS      ] ================== //
    // =========================================================== //

    /**
     * Executa o filtro de autorização.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param request A requisição http.
     * @param response A resposta da requisição http.
     * @param filterChain A cadeia de filtros.
     * @throws IOException caso algum recurso não seja encontrado.
     * @throws ServletException caso haja algum erro de servlet.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        // Estabelece processo de autenticação

        Authentication auth = new JWTTokenAuthenticationService()
                .getAuthentication((HttpServletRequest) request, (HttpServletResponse) response);

        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);

    }

}
