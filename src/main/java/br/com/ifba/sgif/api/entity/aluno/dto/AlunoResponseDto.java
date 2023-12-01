package br.com.ifba.sgif.api.entity.aluno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Giovane Neves
 *
 * DTO para resposta às requisições direcionadas à entidade 'aluno'.
 * @param id
 * @param matricula
 * @param nome
 */
public record AlunoResponseDto(
        @JsonProperty(value = "id")
        Long id,
        @JsonProperty(value = "matricula")
        String matricula,
        @JsonProperty(value = "nome")
        String nome
) {
}
