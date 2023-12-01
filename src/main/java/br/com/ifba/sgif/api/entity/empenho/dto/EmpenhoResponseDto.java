package br.com.ifba.sgif.api.entity.empenho.dto;

import br.com.ifba.sgif.api.entity.item.dto.ItemResponseDto;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioResponseDto;

import br.com.ifba.sgif.api.entity.item.model.Item;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Este DTO representa as informações de um empenho.
 *
 * @param nota - A nota do empenho.
 * @param criador - O criador do empenho.
 * @param itens - A lista de itens do empenho.
 * 
 * Veja também: {@link Item}
 * Veja também: {@link Usuario}
 */
public record EmpenhoResponseDto(
        @JsonProperty(value = "id")
        Long id,

        @JsonProperty(value = "nota")
        String nota,

        @JsonProperty(value = "criador")
        UsuarioResponseDto criador,

        @JsonProperty(value = "itens")
        List<ItemResponseDto> itens
) {
}
