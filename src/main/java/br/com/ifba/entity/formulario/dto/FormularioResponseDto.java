package br.com.ifba.entity.formulario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FormularioResponseDto(
    @JsonProperty(value = "titulo")
    String titulo,
    @JsonProperty(value = "descricao")
    String descricao
) {
}
