package br.com.ifba.entity.tipodeitem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para representar a resposta de dados relacionados à entidade 'TipoDeItem'.
 * 
 * @param nome - O nome do tipo de item.
 * @param descricao - A descrição do tipo de item.
 * @param criador - O criador do tipo de item.
 * 
 * Veja também: {@link br.com.ifba.entity.tipodeitem.model.TipoDeItem}
 * Veja também: {@link br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto}
 */
public record TipoDeItemResponseDto(

        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "descricao")
        String descricao,

        @JsonProperty(value = "criador")
        UsuarioSimpleResponseDto criador
) {
}
