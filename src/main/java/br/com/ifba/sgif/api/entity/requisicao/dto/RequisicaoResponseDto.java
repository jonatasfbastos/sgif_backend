package br.com.ifba.sgif.api.entity.requisicao.dto;

import br.com.ifba.sgif.api.entity.item.model.Item;
import br.com.ifba.sgif.api.entity.perfilusuario.dto.PerfilUsuarioResponseDto;
import br.com.ifba.sgif.api.entity.setor.dto.SetorResponseDto;
import br.com.ifba.sgif.api.entity.requisicao.model.Requisicao;
import br.com.ifba.sgif.api.entity.setor.model.Setor;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um objeto de transferência de dados (DTO) para a entidade Requisicao.
 * 
 * Veja também: {@link Requisicao}
 * Veja também: {@link Item}
 * Veja também: {@link Setor}
 */
public record RequisicaoResponseDto(
        @JsonProperty(value = "id")
        Long id,
        
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
        String requisitante

        // TODO: Adicionar ResponseDto de Item
) {

}
