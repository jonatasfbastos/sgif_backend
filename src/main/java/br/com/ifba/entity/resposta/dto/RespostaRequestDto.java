package br.com.ifba.entity.resposta.dto;

import br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * DTO que recebe dados de requisições direcionadas
 * à entidade 'Resposta'.
 *
 * @param texto O conteúdo da mensagem.
 * @param usuario As informações do usuário que está respondendo.
 *
 * Veja também: {@link br.com.ifba.entity.resposta.model.Resposta}
 * Veja também: {@link br.com.ifba.entity.usuario.dto.UsuarioSimpleResponseDto}
 */
public record RespostaRequestDto(
        @JsonProperty(value = "text")
        @NotNull(message = "O conteúdo da resposta é obrigatório")
        @NotBlank(message = "O conteúdo da resposta não pode ser vazio")
        String texto,
        @JsonProperty(value = "usuario")
        @NotNull(message = "O usuário é obrigatório")
        UsuarioSimpleResponseDto usuario
) {
}
