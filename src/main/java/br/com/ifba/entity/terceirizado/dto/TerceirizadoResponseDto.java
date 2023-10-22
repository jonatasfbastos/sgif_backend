package br.com.ifba.entity.terceirizado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.funcaoterceirizado.dto.FuncaoTerceirizadoResponseDto;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'Terceirizado'.
 *
 * @param funcaoTerceirizado - A função do terceirizado.
 */
public record TerceirizadoResponseDto(

        @JsonProperty(value = "funcaoTerceirizado")
        FuncaoTerceirizadoResponseDto funcaoTerceirizado
) {
}
