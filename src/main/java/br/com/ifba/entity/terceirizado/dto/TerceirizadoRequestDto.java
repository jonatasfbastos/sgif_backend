package br.com.ifba.entity.terceirizado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.funcaoterceirizado.dto.FuncaoTerceirizadoRequestDto;

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
