package br.com.ifba.sgif.api.infrastructure.service;

import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@Service
public class TokenService {

    @Value(value = "${chave_secreta}")
    private String CHAVE_SECRETA;

    /**
     * Gera um token para o usuário autenticado.
     *
     * @author Giovane Neves
     * @since Desde V1.0.1
     * @param usuario O usuário autenticado.
     * @return um token AWT para o usuário autenticado.
     */
    public String gerarToken(Usuario usuario){

        return Jwts.builder()
                .setSubject(usuario.getLogin())
                .signWith(SignatureAlgorithm.HS512, CHAVE_SECRETA)
                .compact();
    }

}
