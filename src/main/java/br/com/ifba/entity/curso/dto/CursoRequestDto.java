package br.com.ifba.entity.curso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record CursoRequestDto(

        @JsonProperty(value = "nome")
        @NotNull(message = "O nome do curso é obrigatório")
        @NotNull(message = "O nome do curso não pode ser vazio")
        @Size(min = 3, message = "O nome do curso precisa ter mais de 3 caracteres")
        String nome,
        @JsonProperty(value = "codigo_curso")
        @NotNull(message = "O código do curso é obrigatório")
        @NotNull(message = "O código do curso não pode ser vazio")
        String codigoCurso
) {
}
