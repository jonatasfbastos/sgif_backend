package br.com.ifba.entity.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;

/**
 * DTO para resposta às requisições direcionadas à entidade 'Usuário'.
 * Este DTO representa informações públicas do usuário, incluindo o login.
 *
 * @param login - O login do usuário (username)
 * @param senha - A senha do usuário
 * 
 * Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 * 
 */

public record UsuarioResponseDto(
            /**
             * O login do usuário (username).
             */
            @JsonProperty(value = "login")
            String login,
            /**
             * A senha do usuário.
             * AVISO: A senha será removida ou criptografada posteriormente por motivos de
             * segurança.
             */
            @JsonProperty(value = "senha") 
            String senha,

            @JsonProperty(value = "perfilUsuario") 
            PerfilUsuarioResponseDto perfilUsuario
            ) {
}
