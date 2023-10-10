package br.com.ifba.entity.formulario.dto;

import br.com.ifba.entity.questao.dto.QuestaoRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 *
 * @author Giovane Neves
 *
 * Entidade que recebe dados enviados por requisições
 * direcionadas à entidade 'Formulário'.
 *
 * @param titulo - O título do formulário.
 * @param descricao - A descrição do formulário.
 * @param questoes - As questões do formulário.
 *
 * Veja também: {@link br.com.ifba.entity.formulario.model.Formulario}
 */
public record FormularioRequestDto(
        @JsonProperty(value = "titulo")
        @NotNull(message = "O título do formulário é obrigatório")
        @NotBlank(message = "O título do formulário não pode ser vazio")
        String titulo,

        @JsonProperty(value = "descricao")
        @NotNull(message = "A descrição do formulário é obrigatória")
        @NotBlank(message = "A descrição do formulário não pode ser vazia")
        String descricao,

        @JsonProperty(value = "questoes")
        @NotNull(message = "A lista de questões não pode ser nula")
        List<QuestaoRequestDto> questoes

) {
}
