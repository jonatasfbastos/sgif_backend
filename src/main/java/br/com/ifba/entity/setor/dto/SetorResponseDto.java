package br.com.ifba.entity.setor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto;


/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um objeto de transferência de dados (DTO) para a entidade Setor.
 * 
 * Veja também: {@link br.com.ifba.entity.setor.model.Setor}
 * Veja também: {@link br.com.ifba.entity.usuario.model.Usuario}
 */
public record SetorResponseDto(
        @JsonProperty(value = "nome")
        String nome,

        @JsonProperty(value = "descricao")
        String descricao,

        @JsonProperty(value = "criador")
        UsuarioSimpleResponseDto criador
) {
}
