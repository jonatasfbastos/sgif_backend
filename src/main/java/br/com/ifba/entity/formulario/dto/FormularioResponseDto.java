package br.com.ifba.entity.formulario.dto;

import br.com.ifba.entity.questao.dto.QuestaoResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * @param titulo O título do formulário.
 * @param descricao A descrição do formulário.
 * @param questoes A lista de questões do formulário.
 *
 * Veja também: {@link br.com.ifba.entity.formulario.model.Formulario}
 * Veja também: {@link br.com.ifba.entity.questao.dto.QuestaoResponseDto}
 */
public record FormularioResponseDto(
        @JsonProperty(value = "titulo")
        String titulo,
        @JsonProperty(value = "descricao")
        String descricao,
        @JsonProperty(value = "questoes")
        List<QuestaoResponseDto> questoes
) {

}
