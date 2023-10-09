package br.com.ifba.entity.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andesson Reis
 *
 * DTO para receber dados de requisições direcionadas à entidade 'Usuário'.
 *
 * @param login - O login do usuário (username)
 * @param senha - A senha do usuário
 */
public record UsuarioRequestDto(

        // =========================================================== //
        // =============== [        ATRIBUTOS       ] ================ //
        // =========================================================== //

        @JsonProperty(value = "login")
        @NotNull(message = "O login é obrigatório.")
        @NotNull(message = "O login não pode ser vazio.")
        @Size(min = 3, max = 150, message = "O login precisa ter pelo menos 3 caracteres e 150 no máximo.")
        String login,

        @JsonProperty(value = "senha")
        @NotNull(message = "A senha é obrigatória.")
        @NotNull(message = "A senha não pode ser vazia.")
        String senha

) {
}
