package br.com.ifba.sgif.api.entity.professor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProfessorRequestDto(
    @JsonProperty(value = "id")
    Long id
) {

    // TODO: Adicionar atributos

}
