package br.com.ifba.entity.aluno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestAlunoDto(
        @JsonProperty(value = "matricula")
        String matricula

) {
}
