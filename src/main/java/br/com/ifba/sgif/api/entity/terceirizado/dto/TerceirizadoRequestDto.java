package br.com.ifba.sgif.api.entity.terceirizado.dto;

import br.com.ifba.sgif.api.entity.funcaoterceirizado.dto.FuncaoTerceirizadoRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;


/**
 * @author Andesson Reis
 * @since V1.0.1
 *
 * DTO para receber dados de requisições direcionadas à entidade 'Terceirizado'.
 *
 * @param funcaoTerceirizado - A função do terceirizado.
 */
public record TerceirizadoRequestDto(

        @JsonProperty(value = "funcaoTerceirizado")
        @NotNull(message = "A função do terceirizado é obrigatória.")
        FuncaoTerceirizadoRequestDto funcaoTerceirizado
) {
}
