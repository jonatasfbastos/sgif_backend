package br.com.ifba.sgif.api.entity.etapacurso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EtapaCursoResponseDto(
        @JsonProperty(value = "id")
        Long id

        // TODO: Adicionar atributos
) {
}
