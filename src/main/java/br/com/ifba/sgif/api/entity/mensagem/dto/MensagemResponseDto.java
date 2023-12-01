package br.com.ifba.sgif.api.entity.mensagem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'Mensagem'.
 *
 * @param nome - O nome da mensagem.
 * @param descricao - A descrição da mensagem.
 * @param dataInicio - A data de início da mensagem.
 * @param dataFim - A data de término da mensagem.
 */
public record MensagemResponseDto(
    @JsonProperty(value = "id")
    Long id,

    @JsonProperty(value = "nome")
    String nome,

    @JsonProperty(value = "descricao")
    String descricao,

    @JsonProperty(value = "dataInicio")
    Date dataInicio,

    @JsonProperty(value = "dataFim")
    Date dataFim
) {

}
