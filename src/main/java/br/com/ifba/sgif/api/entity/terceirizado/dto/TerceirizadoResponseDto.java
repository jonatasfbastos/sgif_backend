package br.com.ifba.sgif.api.entity.terceirizado.dto;

import br.com.ifba.sgif.api.entity.funcaoterceirizado.dto.FuncaoTerceirizadoResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'Terceirizado'.
 *
 * @param funcaoTerceirizado - A função do terceirizado.
 */
public record TerceirizadoResponseDto(
        @JsonProperty(value = "id")
        Long id,
        
        @JsonProperty(value = "funcaoTerceirizado")
        FuncaoTerceirizadoResponseDto funcaoTerceirizado
) {
}
