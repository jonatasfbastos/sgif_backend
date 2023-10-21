package br.com.ifba.entity.requisicao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequisicaoRequestDto(
        @JsonProperty(value = "codigo_saida")
        String codigoSaida,
        @JsonProperty(value = "status")
        boolean status,
        @JsonProperty(value = "quantidade_itens_requisicao")
        int quantidadeItensReq,
        @JsonProperty(value = "requisitante")
        String requisitante
) {
}
