package br.com.ifba.entity.resposta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Giovane Neves
 *
 * DTO que recebe dados de requisições direcionadas
 * à entidade 'Resposta'.
 *
 * @param texto - O conteúdo da mensagem.
 * @param usuarioLogin - O login do usuário que está respondendo.
 *
 * Veja também: {@link br.com.ifba.entity.resposta.model.Resposta}
 */
public record RespostaRequestDto(
        @JsonProperty(value = "text")
        @NotNull(message = "O conteúdo da resposta é obrigatório")
        @NotBlank(message = "O conteúdo da resposta não pode ser vazio")
        String texto,
        @JsonProperty(value = "usuario_login")
        @NotNull(message = "O usuário é obrigatório")
        @NotBlank(message = "O login do usuário não pode ser vazio")
        String usuarioLogin
) {
}
