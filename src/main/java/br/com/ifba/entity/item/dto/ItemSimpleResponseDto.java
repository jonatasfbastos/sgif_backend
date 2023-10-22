package br.com.ifba.entity.item.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *
 * @author Andesson Reis
 *
 * Entidade que representa uma resposta simplificada de uma requisição
 * relacionada à entidade 'Item'.
 *
 * @param id - O ID do item.
 * @param nome - O nome do item.
 * @param quantidade - A quantidade do item.
 * @param valorItem - O valor do item.
 * @param validade - A data de validade do item.
 */
public record ItemSimpleResponseDto(
        @JsonProperty(value = "id")
        Long id,

        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "quantidade")
        int quantidade,

        @JsonProperty(value = "valorItem")
        double valorItem,

        @JsonProperty(value = "validade")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        Date validade
) {
}
