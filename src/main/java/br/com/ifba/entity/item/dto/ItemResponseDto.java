package br.com.ifba.entity.item.dto;

import br.com.ifba.entity.empenho.dto.EmpenhoResponseDto;
import br.com.ifba.entity.fornecedor.dto.FornecedorResponseDto;
import br.com.ifba.entity.requisicao.dto.RequisicaoResponseDto;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Andesson Reis
 *
 * Entidade que representa a resposta de consultas à entidade 'Item'.
 *
 * @param nome - O nome do item.
 * @param unidadeMedida - A unidade de medida do item.
 * @param alerta - O valor de alerta do item.
 * @param quantidade - A quantidade do item.
 * @param quantidadeMinima - A quantidade mínima do item.
 * @param criador - O criador do item.
 * @param relatorioMensal - O relatório mensal do item.
 * @param validade - A data de validade do item.
 * @param dataNot - A data de notificação do item.
 * @param valorItem - O valor do item.
 * @param perecível - Indica se o item é perecível.
 * @param codigoItem - O código do item de empenho.
 * @param fornecedor - O fornecedor do item.
 * @param tipoDeItem - O tipo de item.
 * @param empenhos - A lista de empenhos do item.
 * @param requisicoes - A lista de requisições do item.
 * 
 * Veja também: {@link br.com.ifba.entity.item.model.Item}
 * Veja também: {@link br.com.ifba.entity.requisicao.model.Requisicao}
 * Veja também: {@link br.com.ifba.entity.tipodeitem.model.TipoDeItem}
 * Veja também: {@link br.com.ifba.entity.fornecedor.model.Fornecedor}
 */
public record ItemResponseDto(

        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "unidadeMedida")
        String unidadeMedida,

        @JsonProperty(value = "alerta")
        int alerta,

        @JsonProperty(value = "quantidade")
        int quantidade,

        @JsonProperty(value = "quantidadeMinima")
        int quantidadeMinima,

        @JsonProperty(value = "criador")
        UsuarioResponseDto criador,

        @JsonProperty(value = "relatorioMensal")
        RelatorioMensalResponseDto relatorioMensal,

        @JsonProperty(value = "validade")
        Date validade,

        @JsonProperty(value = "dataNot")
        Date dataNot,

        @JsonProperty(value = "valorItem")
        double valorItem,

        @JsonProperty(value = "perecivel")
        String perecivel,

        @JsonProperty(value = "codigoItem")
        EmpenhoResponseDto codigoItem,

        @JsonProperty(value = "fornecedor")
        FornecedorResponseDto fornecedor,

        @JsonProperty(value = "tipoDeItem")
        TipoDeItemResponseDto tipoDeItem,

        @JsonProperty(value = "empenhos")
        List<EmpenhoResponseDto> empenhos,

        @JsonProperty(value = "requisicoes")
        List<RequisicaoResponseDto> requisicoes
) {
}
