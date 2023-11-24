package br.com.ifba.sgif.api.infrastructure.service;

import br.com.ifba.sgif.api.ApplicationContextLoad;
import br.com.ifba.sgif.api.entity.usuario.dao.IDaoUsuario;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class JWTTokenAuthenticationService {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    // Tempo de expiração do Token: 30 dias.
    private static final long EXPIRATION_TIME = 2_592_000_000L;
    private static final String SECRET_KEY = "secreta"; // TODO: Configurar chave secreta como variável de ambiente.
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";


    // =========================================================== //
    // =============== [         MÉTODOS      ] ================== //
    // =========================================================== //

    /**
     * Gera um token JWT para dar autorização ao usuário válido.
     *
     * @author Giovane Neves
     * @since V1.0.1
     * @param response O objeto de response da requisição.
     * @param username O username do usuário.
     * @throws Exception caso haja alguma operação inválida.
     */
    public void addAuthorization(HttpServletResponse response, final String username) throws Exception{

        final String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date((System.currentTimeMillis() + EXPIRATION_TIME)))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

        // Exemplo: "Bearer json.web.token"
        final String TOKEN = TOKEN_PREFIX.concat(" ").concat(JWT);

        response.addHeader(HEADER_STRING, TOKEN);
        this.allowCors(response);

        // WARN: Apenas para testes!
        // TODO: Remover antes de colocar em produção
        response.getWriter().write(
                """
                {
                "Authorization" : "%s"
                }
                """.formatted(TOKEN)
        );
    }

    /**
     * Recupera autenticação de usuário.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param request A requisição http.
     * @param response A resposta http.
     * @return um objeto com autorizações do usuário,
     * ou nulo, caso o usuário seja inválido.
     */
    public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response){

        String token = request.getHeader(HEADER_STRING);

        if(token != null){

            final String CLEAN_TOKEN = token.replace(TOKEN_PREFIX, "").trim();

            String user = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(CLEAN_TOKEN)
                    .getBody()
                    .getSubject();

            if(user != null){

                Usuario usuario = ApplicationContextLoad.getApplicationContext()
                        .getBean(IDaoUsuario.class)
                        .findUserByLogin(user)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

                return new UsernamePasswordAuthenticationToken(
                        usuario.getLogin(),
                        usuario.getSenha(),
                        usuario.getAuthorities()
                );

            }

        }

        allowCors(response);
        return null;

    }

    /**
     * Permite CORS internamente.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param response O objeto de resposta da requisição http.
     */
    private void allowCors(HttpServletResponse response){

        final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
        final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
        final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";

        List<String> headers = new ArrayList<>(List.of(
                ACCESS_CONTROL_ALLOW_ORIGIN,
                ACCESS_CONTROL_ALLOW_HEADERS,
                ACCESS_CONTROL_ALLOW_METHODS,
                ACCESS_CONTROL_REQUEST_HEADERS
        ));

        headers.forEach(h -> {

                    if(response.getHeader(h) == null)
                        response.setHeader(h, "*");

                });

    }
}
