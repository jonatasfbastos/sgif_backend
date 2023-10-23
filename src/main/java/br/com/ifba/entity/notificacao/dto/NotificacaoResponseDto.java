package br.com.ifba.entity.notificacao.dto;

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

public class NotificacaoResponseDto {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "body")
    private String body;

    @JsonProperty(value = "whatId")
    private Long whatId;

    @JsonProperty(value = "whatObjectName")
    private String whatObjectName;

    @JsonProperty(value = "read")
    private boolean read;

    @JsonProperty(value = "sendDateTime")
    private LocalDateTime sendDateTime;

}
