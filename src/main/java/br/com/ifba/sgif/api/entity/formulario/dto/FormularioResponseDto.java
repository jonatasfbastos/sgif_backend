package br.com.ifba.sgif.api.entity.formulario.dto;

import br.com.ifba.sgif.api.entity.questao.dto.QuestaoResponseDto;
import br.com.ifba.sgif.api.entity.formulario.model.Formulario;
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
 * Veja também: {@link Formulario}
 * Veja também: {@link QuestaoResponseDto}
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
