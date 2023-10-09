package br.com.ifba.entity.questao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Giovane Neves
 *
 * DTO que recebe dados de requisições direcionadas à entidade 'Questão'.
 *
 * @param enunciado - O enunciado da questão.
 * @param resposta - A resposta da questão
 */
public record QuestaoRequestDto(
    @JsonProperty(value = "enunciado")
    @NotNull(message = "O enunciado é obrigatório.")
    @NotBlank(message = "O enunciado não pode ser vazio.")
    String enunciado,

    @JsonProperty(value = "resposta")
    @NotNull(message = "O enunciado é obrigatório.")
    @NotBlank(message = "O enunciado não pode ser vazio.")
    String resposta

) {
}
