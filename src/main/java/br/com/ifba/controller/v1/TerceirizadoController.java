package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.terceirizado.service.IServiceTerceirizado;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar terceirizados.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.terceirizado.model.Terceirizado}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class TerceirizadoController {
    
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    @Autowired
    IServiceTerceirizado terceirizadoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //
}
