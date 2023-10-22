package br.com.ifba.entity.relatoriomensal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ifba.entity.item.dto.ItemRequestDto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * DTO para receber dados de requisições direcionadas à entidade 'RelatorioMensal'.
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
public record RelatorioMensalRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome é obrigatório.")
        @NotBlank(message = "O nome não pode ser vazio.")
        @Size(min = 1, max = 255, message = "O nome deve ter entre 1 e 255 caracteres.")
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
        @NotNull(message = "A data é obrigatória.")
        @NotBlank(message = "A data não pode ser vazia.")
        String data,

        @JsonProperty(value = "item_id")
        ItemRequestDto item
) {
}
