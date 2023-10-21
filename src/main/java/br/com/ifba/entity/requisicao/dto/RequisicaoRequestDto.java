package br.com.ifba.entity.requisicao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Andesson Reis, Giovane Neves
 * @since Desde V1.0.1
 * <p>
 * DTO para receber dados de requisições direcionadas à entidade 'Requisicao'.
 * <p>
 * @param codigoSaida O código de saída da requisição.
 * @param status O status da requisição.
 * @param quantidadeItensRequisicao A quantidade de itens na requisição.
 * @param setor O setor da requisição.
 * @param nomeRequisitante O nome do requisitante da requisição.
 * <p>
 * Veja também: {@link br.com.ifba.entity.requisicao.model.Requisicao}
 */
public record RequisicaoRequestDto(
        @JsonProperty(value = "codigo_saida")
        @NotNull(message = "O código de saída é obrigatório.")
        @NotBlank(message = "O código de saída não pode ser vazio.")
        String codigoSaida,

        @JsonProperty(value = "status")
        boolean status,

        @JsonProperty(value = "quantidade_itens_requisicao")
        int quantidadeItensReq,

        // TODO: Adicionar RequestDto de 'PerfilUsuario'

        // TODO: Adicionar RequestDto de 'Setor'

        @JsonProperty(value = "requisitante")
        @NotNull(message = "O nome do requisitante é obrigatório.")
        @NotBlank(message = "O nome do requisitante não pode ser vazio.")
        String requisitante

        // TODO: Adicionar RequestDto de 'Item'

) {
}
