package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.notificacao.service.IServiceNotificacao;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar notificações.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.notificacao.model.Notificacao}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class NotificacaoController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    @Autowired
    IServiceNotificacao notificacaoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //

    /**
     * Obtém a lista de todas as notificações.
     *
     * @return Uma lista de notificações ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/notificacoes", consumes = "application/json")
    public ResponseEntity<?> getNotificacoes() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(notificacaoService.getAllNotification());
    }
}
