package br.com.ifba.sgif.api.entity.mensagem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * DTO para receber dados de requisições direcionadas à entidade 'Mensagem'.
 *
 * @param nome - O nome da mensagem (não pode ser nulo).
 * @param descricao - A descrição da mensagem (não pode ser nula).
 * @param dataInicio - A data de início da mensagem (deve ser passada no passado ou presente).
 * @param dataFim - A data de término da mensagem (deve ser passada no passado ou presente).
 */
public class MensagemRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "O nome da mensagem é obrigatório.")
    @NotBlank(message = "O nome da mensagem não pode ser vazio.")
    private String nome;

    @JsonProperty(value = "descricao")
    @NotNull(message = "A descrição da mensagem é obrigatória.")
    @NotBlank(message = "A descrição da mensagem não pode ser vazia.")
    private String descricao;

    @JsonProperty(value = "dataInicio")
    @NotNull(message = "A data de início da mensagem é obrigatória.")
    @PastOrPresent(message = "A data de início da mensagem deve ser no passado ou presente.")
    private Date dataInicio;

    @JsonProperty(value = "dataFim")
    @NotNull(message = "A data de término da mensagem é obrigatória.")
    @PastOrPresent(message = "A data de término da mensagem deve ser no passado ou presente.")
    private Date dataFim;
}
