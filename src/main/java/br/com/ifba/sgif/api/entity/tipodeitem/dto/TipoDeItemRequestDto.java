package br.com.ifba.sgif.api.entity.tipodeitem.dto;

import br.com.ifba.sgif.api.entity.tipodeitem.model.TipoDeItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioSimpleResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para receber dados de requisições direcionadas à entidade 'TipoDeItem'.
 *
 * @param nome - O nome do tipo de item.
 * @param descricao - A descrição do tipo de item.
 * @param criador - O criador do tipo de item.
 * 
 * Veja também: {@link TipoDeItem}
 * Veja também: {@link br.com.ifba.entity.usuario.model.UsuarioSimpleResponseDto}
 */
public record TipoDeItemRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome do tipo de item é obrigatório.")
        @NotBlank(message = "O nome do tipo de item não pode ser vazio.")
        String nome,

        @JsonProperty(value = "descricao")
        @NotNull(message = "A descrição do tipo de item é obrigatória.")
        @NotBlank(message = "A descrição do tipo de item não pode ser vazia.")
        String descricao,

        @JsonProperty(value = "criador")
        UsuarioSimpleResponseDto criador
) {
}
