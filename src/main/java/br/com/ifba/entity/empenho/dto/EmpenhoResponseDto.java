package br.com.ifba.entity.empenho.dto;

import br.com.ifba.entity.item.dto.ItemResponseDto;
import br.com.ifba.entity.usuario.dto.UsuarioResponseDto;

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
 * Veja também: {@link br.com.ifba.entity.item.model.Item}
 * Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 */
public record EmpenhoResponseDto(
        @JsonProperty(value = "nota")
        String nota,

        @JsonProperty(value = "criador")
        UsuarioResponseDto criador,

        @JsonProperty(value = "itens")
        List<ItemResponseDto> itens
) {
}
