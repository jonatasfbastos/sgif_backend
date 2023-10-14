package br.com.ifba.entity.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioSimpleResponseDto(
        /**
         * O login do usuário (username).
         */
        @JsonProperty(value = "login")
        String login
) {
}
