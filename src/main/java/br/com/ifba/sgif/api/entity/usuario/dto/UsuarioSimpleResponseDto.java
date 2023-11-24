package br.com.ifba.sgif.api.entity.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSimpleResponseDto{

        /**
         * O login do usuário (username).
         */
        @JsonProperty(value = "login")
        String login;

}
