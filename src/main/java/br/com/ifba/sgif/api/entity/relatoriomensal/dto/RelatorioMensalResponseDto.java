package br.com.ifba.sgif.api.entity.relatoriomensal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.sgif.api.entity.item.dto.ItemSimpleResponseDto;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'RelatorioMensal'.
 *
 * @param nome - O nome do relatório mensal.
 * @param qtdInicial - A quantidade inicial.
 * @param qtdEntrou - A quantidade que entrou.
 * @param qtdSaiu - A quantidade que saiu.
 * @param valorTotal - O valor total.
 * @param valorTotalSairam - O valor total das saídas.
 * @param data - A data do relatório mensal.
 * @param item - Informações do item associado ao relatório.
 */
public record RelatorioMensalResponseDto(
        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "qtdInicial")
        int qtdInicial,

        @JsonProperty(value = "qtdEntrou")
        int qtdEntrou,

        @JsonProperty(value = "qtdSaiu")
        int qtdSaiu,

        @JsonProperty(value = "valorTotal")
        float valorTotal,

        @JsonProperty(value = "valorTotalSairam")
        float valorTotalSairam,

        @JsonProperty(value = "data")
        String data,

        @JsonProperty(value = "item")
        ItemSimpleResponseDto item
) {
}
