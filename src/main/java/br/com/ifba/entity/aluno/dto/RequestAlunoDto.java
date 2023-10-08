package br.com.ifba.entity.aluno.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SalvarAlunoDto(
        @JsonProperty(value = "matricula")
        String matricula,
                
) {
}
