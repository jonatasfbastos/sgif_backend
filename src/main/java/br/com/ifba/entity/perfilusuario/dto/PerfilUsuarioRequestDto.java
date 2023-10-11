package br.com.ifba.entity.perfilusuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PerfilUsuarioRequestDto(
        @JsonProperty(value = "nome")
        String nome,
        @JsonProperty(value = "descricao")
        String descricao
) {
}
