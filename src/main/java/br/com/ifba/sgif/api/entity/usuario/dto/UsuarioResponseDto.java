package br.com.ifba.sgif.api.entity.usuario.dto;

import br.com.ifba.sgif.api.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andesson Reis, Giovane Neves
 * @since Desde V1.0.1
 * DTO para resposta às requisições direcionadas à entidade 'Usuário'.
 * Este DTO representa informações públicas do usuário, incluindo o login.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UsuarioResponseDto {

    /**
     * O login do usuário (username).
     */
    @JsonProperty(value = "login")
    private String login;

    /**
     * A senha do usuário.
     */
    @JsonProperty(value = "senha")
    private String senha;

    @JsonProperty(value = "perfilUsuario")
    private PerfilUsuarioResponseDto perfilUsuario;
}
