package br.com.ifba.sgif.api.entity.servidor.dto;

import br.com.ifba.sgif.api.entity.funcaoservidor.dto.FuncaoServidorResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'Servidor'.
 *
 * @param siape - O número do SIAPE do servidor.
 * @param funcaoServidor - Informações da função do servidor.
 */
public record ServidorResponseDto(
    @JsonProperty(value = "id")
    Long id,

    @JsonProperty(value = "siape")
    String siape,

    @JsonProperty(value = "funcaoServidor")
    FuncaoServidorResponseDto funcaoServidor
) {
}
