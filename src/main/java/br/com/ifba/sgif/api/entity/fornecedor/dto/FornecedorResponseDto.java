package br.com.ifba.sgif.api.entity.fornecedor.dto;

import br.com.ifba.sgif.api.entity.item.dto.ItemResponseDto;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Entidade que representa uma resposta de dados para a entidade 'Fornecedor'.
 *
 * @param nome - O nome do fornecedor.
 * @param email - O email do fornecedor.
 * @param cnpj - O CNPJ do fornecedor.
 * @param telefone - O telefone do fornecedor.
 * @param inscricaoEstadual - A inscrição estadual do fornecedor.
 * @param criador - O criador do fornecedor.
 * @param itens - A lista de itens fornecidos pelo fornecedor.
 */
public record FornecedorResponseDto(
        @JsonProperty(value = "id")
        Long id,

        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "email")
        String email,

        @JsonProperty(value = "cnpj")
        String cnpj,

        @JsonProperty(value = "telefone")
        String telefone,

        @JsonProperty(value = "inscricaoEstadual")
        String inscricaoEstadual,

        @JsonProperty(value = "criador")
        UsuarioResponseDto criador,

        @JsonProperty(value = "itens")
        List<ItemResponseDto> itens
) {
}
