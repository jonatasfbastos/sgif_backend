package br.com.ifba.entity.questao.dto;

import br.com.ifba.entity.resposta.dto.RespostaRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 *
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * DTO que recebe dados de requisições direcionadas à entidade 'Questão'.
 *
 * @param enunciado - O enunciado da questão.
 * @param respostas - As respostas da questão
 *
 * Veja também: {@link br.com.ifba.entity.questao.model.Questao}
 * Veja também: {@link br.com.ifba.entity.resposta.dto.RespostaRequestDto}
 *
 */
public record QuestaoRequestDto(
    @JsonProperty(value = "enunciado")
    @NotNull(message = "O enunciado é obrigatório.")
    @NotBlank(message = "O enunciado não pode ser vazio.")
    String enunciado,

    @JsonProperty(value = "respostas")
    List<RespostaRequestDto> respostas

) {
}
