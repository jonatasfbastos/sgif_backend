package br.com.ifba.entity.requisicao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para receber dados de requisições direcionadas à entidade 'Requisicao'.
 *
 * @param codigoSaida - O código de saída da requisição.
 * @param status - O status da requisição.
 * @param quantidadeItensRequisicao - A quantidade de itens na requisição.
 * @param criador - O criador da requisição.
 * @param setor - O setor da requisição.
 * @param nomeRequisitante - O nome do requisitante da requisição.
 * @param itens - Os itens da requisição.
 * 
 * Veja também: {@link br.com.ifba.entity.requisicao.model.Requisicao}
 */
public record RequisicaoRequestDto(
        @JsonProperty(value = "codigoSaida")
        @NotNull(message = "O código de saída é obrigatório.")
        @NotBlank(message = "O código de saída não pode ser vazio.")
        String codigoSaida,

        @JsonProperty(value = "status")
        boolean status,

        @JsonProperty(value = "quantidadeItensRequisicao")
        int quantidadeItensRequisicao,

        @JsonProperty(value = "criador")
        PerfilUsuarioResponseDto criador,

        @JsonProperty(value = "setor")
        SetorResponseDto setor,

        @JsonProperty(value = "nomeRequisitante")
        @NotNull(message = "O nome do requisitante é obrigatório.")
        @NotBlank(message = "O nome do requisitante não pode ser vazio.")
        String nomeRequisitante,

        @JsonProperty(value = "itens")
        ItemResponseDto itens
) {
}
