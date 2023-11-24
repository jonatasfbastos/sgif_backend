package br.com.ifba.sgif.api.entity.empenho.dto;

import br.com.ifba.sgif.api.entity.item.dto.ItemRequestDto;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioRequestDto;

import br.com.ifba.sgif.api.entity.item.model.Item;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Este DTO recebe informações de requisições direcionadas à entidade 'Empenho'.
 *
 * @param nota - A nota do empenho, não pode ser nula.
 * @param criador - O criador do empenho, não pode ser nulo.
 * @param itens - A lista de itens do empenho.
 * 
 * Veja também: {@link Item}
 * Veja também: {@link Usuario}
 */
public record EmpenhoRequestDto(
        @JsonProperty(value = "nota")
        @NotNull(message = "A nota do empenho é obrigatória")
        @NotBlank(message = "A nota do empenho não pode ser vazia")
        String nota,

        @JsonProperty(value = "criador")
        @NotNull(message = "O criador do empenho é obrigatório")
        UsuarioRequestDto criador,

        @JsonProperty(value = "itens")
        List<ItemRequestDto> itens
) {
}
