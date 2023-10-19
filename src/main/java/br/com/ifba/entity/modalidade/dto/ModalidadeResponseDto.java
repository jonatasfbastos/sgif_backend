package br.com.ifba.entity.modalidade.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * DTO para retornar dados em respostas
 * de requisições direcionadas à entidade 'Modalidade'.
 *
 * @param nome O nome da modalidade.
 * @param descricao A descrição da modalidade.
 *
 * Veja também: {@link br.com.ifba.entity.modalidade.model.Modalidade}
 */
public record ModalidadeResponseDto(
        @JsonProperty(value = "nome")
        String nome,
        @JsonProperty(value = "descricao")
        String descricao
) {
}
