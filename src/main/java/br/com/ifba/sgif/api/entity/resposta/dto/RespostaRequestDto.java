package br.com.ifba.sgif.api.entity.resposta.dto;

import br.com.ifba.sgif.api.entity.usuario.dto.UsuarioSimpleResponseDto;
import br.com.ifba.sgif.api.entity.resposta.model.Resposta;
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
 * Veja também: {@link Resposta}
 * Veja também: {@link UsuarioSimpleResponseDto}
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
