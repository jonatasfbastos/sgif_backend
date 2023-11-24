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
public class MensagemResponseDto {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "dataInicio")
    private Date dataInicio;

    @JsonProperty(value = "dataFim")
    private Date dataFim;
}
