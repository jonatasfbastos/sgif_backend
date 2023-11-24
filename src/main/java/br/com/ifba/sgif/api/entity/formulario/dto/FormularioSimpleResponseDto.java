package br.com.ifba.sgif.api.entity.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FormularioSimpleResponseDto(
    @JsonProperty(value = "titulo")
    String titulo,
    @JsonProperty(value = "descricao")
    String descricao
) {
}
