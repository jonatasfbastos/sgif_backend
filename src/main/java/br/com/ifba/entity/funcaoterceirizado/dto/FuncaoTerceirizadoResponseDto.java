package br.com.ifba.entity.funcaoterceirizado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'FuncaoTerceirizado'.
 *
 * @param nome - O nome da função do terceirizado.
 * @param descricao - A descrição da função do terceirizado.
 * @param terceirizados - Lista de terceirizados associados a esta função.
 */
public record FuncaoTerceirizadoResponseDto(
        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "descricao")
        String descricao,

        @JsonProperty(value = "terceirizados")
        List<TerceirizadoResponseDto> terceirizados
) {
}
