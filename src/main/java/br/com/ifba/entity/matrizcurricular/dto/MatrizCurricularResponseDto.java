package br.com.ifba.entity.matrizcurricular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Giovane Neves
 *
 * DTO para respostas de requisições direcionadas
 * à entidade 'MatrizCurricular'.
 * 
 * @param nome O nome da matriz curricular.
 * @param descricao A descrição da matriz curricular.
 *
 * Veja também: {@link br.com.ifba.entity.matrizcurricular.model.MatrizCurricular}
 */
public record MatrizCurricularResponseDto(
        @JsonProperty(value = "nome")
        String nome,
        @JsonProperty(value = "descricao")
        String descricao

        // TODO: Adicionar (e criar, caso não exista) o DTO 'EtapaCursoResponseDTO'.
) {
}
