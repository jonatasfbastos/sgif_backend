package br.com.ifba.sgif.api.entity.item.dto;

import br.com.ifba.sgif.api.entity.empenho.dto.EmpenhoRequestDto;
import br.com.ifba.sgif.api.entity.fornecedor.dto.FornecedorRequestDto;
import br.com.ifba.sgif.api.entity.relatoriomensal.dto.RelatorioMensalRequestDto;
import br.com.ifba.sgif.api.entity.requisicao.dto.RequisicaoRequestDto;
import br.com.ifba.sgif.api.entity.tipodeitem.dto.TipoDeItemRequestDto;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Entidade que recebe dados enviados por requisições
 * direcionadas à entidade 'Item'.
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
 * @param perecivel - Indica se o item é perecível.
 * @param codigoItem - O código do item de empenho.
 * @param fornecedor - O fornecedor do item.
 * @param tipoDeItem - O tipo de item.
 * @param empenhos - A lista de empenhos do item.
 * @param requisicoes - A lista de requisições do item.
 */
public record ItemRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome do item é obrigatório")
        @NotBlank(message = "O nome do item não pode ser vazio")
        String nome,

        @JsonProperty(value = "unidadeMedida")
        @NotNull(message = "A unidade de medida do item é obrigatória")
        @NotBlank(message = "A unidade de medida do item não pode ser vazia")
        String unidadeMedida,

        @JsonProperty(value = "alerta")
        @PositiveOrZero(message = "O valor de alerta deve ser não negativo")
        int alerta,

        @JsonProperty(value = "quantidade")
        @PositiveOrZero(message = "A quantidade do item deve ser não negativa")
        int quantidade,

        @JsonProperty(value = "quantidadeMinima")
        @PositiveOrZero(message = "A quantidade mínima do item deve ser não negativa")
        int quantidadeMinima,

        @JsonProperty(value = "criador")
        @NotNull(message = "O criador do item é obrigatório")
        UsuarioRequestDto criador,

        @JsonProperty(value = "relatorioMensal")
        RelatorioMensalRequestDto relatorioMensal,

        @JsonProperty(value = "validade")
        Date validade,

        @JsonProperty(value = "dataNot")
        Date dataNot,

        @JsonProperty(value = "valorItem")
        double valorItem,

        @JsonProperty(value = "perecivel")
        String perecivel,

        @JsonProperty(value = "codigoItem")
        EmpenhoRequestDto codigoItem,

        @JsonProperty(value = "fornecedor")
        FornecedorRequestDto fornecedor,

        @JsonProperty(value = "tipoDeItem")
        TipoDeItemRequestDto tipoDeItem,

        @JsonProperty(value = "empenhos")
        List<EmpenhoRequestDto> empenhos,

        @JsonProperty(value = "requisicoes")
        List<RequisicaoRequestDto> requisicoes
) {
}
