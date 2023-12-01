package br.com.ifba.sgif.api.entity.turma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TurmaResponseDto(
    @JsonProperty(value = "id")
    Long id
) {
}  
    // TODO: Adicionar Atributos


