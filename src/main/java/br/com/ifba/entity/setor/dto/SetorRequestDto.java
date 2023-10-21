package br.com.ifba.entity.setor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para receber dados de requisições direcionadas à entidade 'Setor'.
 *
 * @param nome - O nome do setor.
 * @param descricao - A descrição do setor.
 * @param criador - O criador do setor.
 * 
 * Veja também: {@link br.com.ifba.entity.setor.model.Setor}
 * Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 */
public record SetorRequestDto(
        @JsonProperty(value = "nome")
        @NotNull(message = "O nome do setor é obrigatório.")
        @NotBlank(message = "O nome do setor não pode ser vazio.")
        String nome,

        @JsonProperty(value = "descricao")
        @NotNull(message = "A descrição do setor é obrigatória.")
        @NotBlank(message = "A descrição do setor não pode ser vazia.")
        String descricao,

        @JsonProperty(value = "criador")
        UsuarioSimpleResponseDto criador
) {
}
