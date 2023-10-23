package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.mensagem.service.IServiceMensagem;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
/**
 * @author Andesson reis
 * @since V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class MensagemController {
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IServiceMensagem mensagemService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Obtém a lista de todas as mensagens.
     *
     * @return Uma lista de mensagens ou uma resposta de erro em caso de falha.
     */
    @GetMapping(consumes = "application/json")
    public ResponseEntity<?> getMensagens() {
        return ResponseEntity.status(HttpStatus.OK).body(mensagemService.getAllMensagem());
    }
}
