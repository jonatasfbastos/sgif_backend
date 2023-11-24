package br.com.ifba.sgif.api.entity.aluno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AlunoRequestDto(
        @JsonProperty(value = "matricula")
        String matricula

) {
}
