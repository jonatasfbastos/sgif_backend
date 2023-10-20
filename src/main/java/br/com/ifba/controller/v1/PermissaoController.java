package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.permissao.service.IServicePermissao;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

public class PermissaoController {
      // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IServicePermissao permissaoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // ===========================
}
