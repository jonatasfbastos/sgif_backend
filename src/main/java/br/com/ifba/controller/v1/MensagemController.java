package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.mensagem.service.IServiceMensagem;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
/**
 * @author Andesson reis
 * @since V1.0.1
 */

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
}
