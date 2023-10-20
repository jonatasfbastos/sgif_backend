package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.permissaolink.service.IServicePermissaoLink;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

public class PermissaoLinkController {
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IServicePermissaoLink permissaoLinkService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //
}
