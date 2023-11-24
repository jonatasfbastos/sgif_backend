package br.com.ifba.sgif.api.entity.setor.dto;

import br.com.ifba.sgif.api.entity.setor.model.Setor;
import br.com.ifba.sgif.api.entity.usuario.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioSimpleResponseDto;


/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Esta classe representa um objeto de transferência de dados (DTO) para a entidade Setor.
 * 
 * Veja também: {@link Setor}
 * Veja também: {@link Usuario}
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
