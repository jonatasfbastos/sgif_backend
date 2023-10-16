package br.com.ifba.entity.questao.dto;

import br.com.ifba.entity.resposta.dto.RespostaResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * Objeto DTO para respostas de requisições direcionadas
 * à entidade 'Questão'.
 *
 * @param enunciado O enunciado da questão.
 * @param respostas A lista de resposta da questão.
 *
 * Veja também: {@link br.com.ifba.entity.questao.model.Questao}
 * Veja também: {@link br.com.ifba.entity.resposta.dto.RespostaResponseDto}
 */
public record QuestaoResponseDto(
        @JsonProperty(value = "enunciado")
        String enunciado,

        @JsonProperty(value = "respostas")
        List<RespostaResponseDto> respostas
) {
}
