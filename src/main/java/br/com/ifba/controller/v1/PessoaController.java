package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.pessoa.service.IServicePessoa;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class PessoaController {
        // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    @Autowired
    IServicePessoa pessoaService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //
}
