package br.com.ifba.entity.fornecedor.dto;

import br.com.ifba.entity.item.dto.ItemRequestDto;
import br.com.ifba.entity.usuario.dto.UsuarioRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Entidade que recebe dados enviados por requisições direcionadas à entidade 'Fornecedor'.
 *
 * @param nome - O nome do fornecedor.
 * @param email - O email do fornecedor.
 * @param cnpj - O CNPJ do fornecedor.
 * @param telefone - O telefone do fornecedor.
 * @param inscricaoEstadual - A inscrição estadual do fornecedor.
 * @param criador - O criador do fornecedor.
 * @param itens - A lista de itens fornecidos pelo fornecedor.
 */
public record FornecedorRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome do fornecedor é obrigatório")
        @NotBlank(message = "O nome do fornecedor não pode ser vazio")
        String nome,

        @JsonProperty(value = "email")
        @NotNull(message = "O email do fornecedor é obrigatório")
        @NotBlank(message = "O email do fornecedor não pode ser vazio")
        String email,

        @JsonProperty(value = "cnpj")
        @NotNull(message = "O CNPJ do fornecedor é obrigatório")
        @NotBlank(message = "O CNPJ do fornecedor não pode ser vazio")
        String cnpj,

        @JsonProperty(value = "telefone")
        @NotNull(message = "O telefone do fornecedor é obrigatório")
        @NotBlank(message = "O telefone do fornecedor não pode ser vazio")
        String telefone,

        @JsonProperty(value = "inscricaoEstadual")
        @NotNull(message = "A inscrição estadual do fornecedor é obrigatória")
        @NotBlank(message = "A inscrição estadual do fornecedor não pode ser vazia")
        String inscricaoEstadual,

        @JsonProperty(value = "criador")
        @NotNull(message = "O criador do fornecedor é obrigatório")
        UsuarioRequestDto criador,

        @JsonProperty(value = "itens")
        List<ItemRequestDto> itens
) {
}
