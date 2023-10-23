package br.com.ifba.entity.servidor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorResponseDto;


/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'Servidor'.
 *
 * @param siape - O número do SIAPE do servidor.
 * @param funcaoServidor - Informações da função do servidor.
 */
public class ServidorResponseDto {

    @JsonProperty(value = "siape")
    private String siape;

    @JsonProperty(value = "funcaoServidor")
    private FuncaoServidorResponseDto funcaoServidor;
}
