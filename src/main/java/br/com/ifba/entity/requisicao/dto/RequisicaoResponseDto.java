package br.com.ifba.entity.requisicao.dto;

import br.com.ifba.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um objeto de transferência de dados (DTO) para a entidade Requisicao.
 * 
 * Veja também: {@link br.com.ifba.entity.requisicao.model.Requisicao}
 * Veja também: {@link br.com.ifba.entity.item.model.Item}
 * Veja também: {@link br.com.ifba.entity.setor.model.Setor}
 */
public record RequisicaoResponseDto(
        @JsonProperty(value = "codigoSaida")
        String codigoSaida,

        @JsonProperty(value = "status")
        boolean status,

        @JsonProperty(value = "quantidadeItensReq")
        int quantidadeItensReq,

        @JsonProperty(value = "criador")
        PerfilUsuarioResponseDto criador,

        @JsonProperty(value = "setor")
        SetorResponseDto setor,

        @JsonProperty(value = "requisitante")
        String requisitante,

        @JsonProperty(value = "itens")
        ItemResponseDto itens
) {

}
