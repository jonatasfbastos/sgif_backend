package br.com.ifba.sgif.api.entity.notificacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * DTO para receber dados de requisições direcionadas à entidade 'Notificacao'.
 *
 * @param title - O título da notificação (não pode ser nulo).
 * @param body - O corpo da notificação (não pode ser nulo).
 * @param whatId - O ID do objeto relacionado à notificação (não pode ser nulo).
 * @param whatObjectName - O nome do objeto relacionado à notificação (não pode ser nulo).
 * @param read - Indica se a notificação foi lida (padrão é falso).
 * @param sendDateTime - Data e hora de envio da notificação.
 */
public class NotificacaoRequestDto {

    @JsonProperty(value = "title")
    @NotNull(message = "O título da notificação é obrigatório.")
    @NotBlank(message = "O título da notificação não pode ser vazio.")
    private String title;

    @JsonProperty(value = "body")
    @NotNull(message = "O corpo da notificação é obrigatório.")
    @NotBlank(message = "O corpo da notificação não pode ser vazio.")
    private String body;

    @JsonProperty(value = "whatId")
    @NotNull(message = "O ID do objeto relacionado à notificação é obrigatório.")
    private Long whatId;

    @JsonProperty(value = "whatObjectName")
    @NotNull(message = "O nome do objeto relacionado à notificação é obrigatório.")
    @NotBlank(message = "O nome do objeto relacionado à notificação não pode ser vazio.")
    private String whatObjectName;

    @JsonProperty(value = "read")
    private boolean read = false;

    @JsonProperty(value = "sendDateTime")
    private LocalDateTime sendDateTime;
}
