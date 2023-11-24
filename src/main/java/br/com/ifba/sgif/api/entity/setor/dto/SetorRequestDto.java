package br.com.ifba.sgif.api.entity.setor.dto;

import br.com.ifba.sgif.api.entity.setor.model.Setor;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioSimpleResponseDto;

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
 * Veja também: {@link Setor}
 * Veja também: {@link Usuario}
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
