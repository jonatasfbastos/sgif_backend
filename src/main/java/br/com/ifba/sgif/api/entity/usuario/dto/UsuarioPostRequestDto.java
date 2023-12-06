package br.com.ifba.sgif.api.entity.usuario.dto;

import br.com.ifba.sgif.api.entity.perfilusuario.dto.PerfilUsuarioRequestDto;
import br.com.ifba.sgif.api.entity.roles.dto.RolePostRequestDto;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;
/**
 *
 * @author Andesson Reis
 *
 * DTO para receber dados de requisições direcionadas à entidade 'Usuário'.
 *
 * @param login - O login do usuário (username)
 * @param senha - A senha do usuário
 * @param perfilUsuario - Informações do perfil de usuário associado ao usuário.
 * 
 * Veja também: {@link Usuario}
 */
public record UsuarioPostRequestDto(

        // =========================================================== //
        // =============== [        ATRIBUTOS       ] ================ //
        // =========================================================== //

        @JsonProperty(value = "login")
        @NotNull(message = "O login é obrigatório.")
        @NotBlank(message = "O login não pode ser vazio.")
        @Size(min = 3, max = 150, message = "O login precisa ter pelo menos 3 caracteres e 150 no máximo.")
        String login,

        @JsonProperty(value = "senha")
        @NotNull(message = "A senha é obrigatória.")
        @NotBlank(message = "A senha não pode ser vazia.")
        String senha,

        @JsonProperty(value = "perfilUsuario")
        PerfilUsuarioRequestDto perfilUsuario,

        @JsonProperty(value = "roles")
        List<RolePostRequestDto> roles

) {
}
