package br.com.ifba.entity.requisicao.dto;

public record RequisicaoRequestDto(
        @JsonProperty(value = "codigo_saida")
        String codigoSaida,
        @JsonProperty(value = "status")
        boolean status,
        @JsonProperty(value = "quantidade_itens_requisicao")
        boolean quantidadeItensReq,
        @JsonProperty(value = "requisitante")
        boolean requisitante
) {
}
