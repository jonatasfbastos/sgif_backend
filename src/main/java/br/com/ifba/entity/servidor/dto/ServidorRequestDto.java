package br.com.ifba.entity.servidor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorRequestDto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para receber dados de requisições direcionadas à entidade 'Servidor'.
 *
 * @param siape - O número do SIAPE do servidor (deve ser único).
 * @param funcaoServidor - Informações da função do servidor.
 */
public class ServidorRequestDto {
    
    @JsonProperty(value = "siape")
    @NotBlank(message = "O número do SIAPE é obrigatório.")
    @Column(unique = true)
    private String siape;

    @JsonProperty(value = "funcaoServidor")
    private FuncaoServidorRequestDto funcaoServidor;
}
