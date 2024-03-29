package br.com.ifba.sgif.api.entity.resposta.dto;

import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioSimpleResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * Objeto de DTO para resposta de requisições
 * direcionadas à entidade 'resposta'.
 *
 * @param texto O conteúdo da resposta.
 * @param usuario O dono da resposta.
 */
public record RespostaResponseDto(
        @JsonProperty(value = "id")
        Long id,
        
        @JsonProperty(value = "text")
        String texto,
        @JsonProperty(value = "usuario")
        UsuarioSimpleResponseDto usuario
) {
}
