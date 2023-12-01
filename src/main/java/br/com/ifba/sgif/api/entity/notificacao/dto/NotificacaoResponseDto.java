package br.com.ifba.sgif.api.entity.notificacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDateTime;

/**
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * DTO para enviar dados em resposta a requisições relacionadas à entidade 'Notificacao'.
 *
 * @param title - O título da notificação.
 * @param body - O corpo da notificação.
 * @param whatId - O ID do objeto relacionado à notificação.
 * @param whatObjectName - O nome do objeto relacionado à notificação.
 * @param read - Indica se a notificação foi lida.
 * @param sendDateTime - Data e hora de envio da notificação.
 */

public record NotificacaoResponseDto(
    @JsonProperty(value = "id")
    Long id,

    @JsonProperty(value = "title")
    String title,

    @JsonProperty(value = "body")
    String body,

    @JsonProperty(value = "whatId")
    Long whatId,

    @JsonProperty(value = "whatObjectName")
    String whatObjectName,

    @JsonProperty(value = "read")
    boolean read,

    @JsonProperty(value = "sendDateTime")
    LocalDateTime sendDateTime
) {}