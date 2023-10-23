package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.notificacao.dto.NotificacaoRequestDto;
import br.com.ifba.entity.notificacao.model.Notificacao;
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
    /**
     * Atualiza uma notificação.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(path = "/notificacoes/notificacao", consumes = "application/json")
    public ResponseEntity<?> atualizarNotificacao(@Valid @RequestBody NotificacaoRequestDto notificacaoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(notificacaoService.updateNotification(objectMapperUtil.map(notificacaoDto, Notificacao.class)));
    }

    /**
     * Salva uma notificação.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/notificacoes/notificacao", consumes = "application/json")
    public ResponseEntity<?> salvarNotificacao(@Valid @RequestBody NotificacaoRequestDto notificacaoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(notificacaoService.saveNotification(objectMapperUtil.map(notificacaoDto, Notificacao.class)));
    }

}
