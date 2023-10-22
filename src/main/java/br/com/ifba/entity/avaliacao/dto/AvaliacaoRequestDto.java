package br.com.ifba.entity.avaliacao.dto;

import br.com.ifba.entity.formulario.dto.FormularioRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * DTO responsável por receber dados de requisições direcionadas
 * à entidade 'Avaliação'.
 *
 * @author Giovane Neves
 * @since Desde V1.0.1
 * @param descricao A descrição da avaliação.
 * @param dataInicio A data de inicío da avaliação.
 * @param dataFim A data de fim da avaliação.
 * @param formulario O formulário atrelado à avaliação.
 */
public record AvaliacaoRequestDto(

        @JsonProperty(value = "descricao")
        @Min(value = 3L, message = "A descrição precisa ter pelo menos 3 caracteres.")
        String descricao,

        @JsonProperty(value = "data_inicio")
        @NotNull(message = "A data de inicio é obrigatória")
        @NotBlank(message = "A data de inicio não pode ser vazia")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "Formato de data inválido (dd/MM/yyyy)")
        String dataInicio,

        @JsonProperty(value = "data_fim")
        @NotNull(message = "A data de fim é obrigatória")
        @NotBlank(message = "A data de fim não pode ser vazia")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "Formato de data inválido (dd/MM/yyyy)")
        String dataFim,

        @JsonProperty(value = "formulario")
        FormularioRequestDto formulario

        // TODO: Adicionar RequestDto de 'Disciplina'.
) {
}
