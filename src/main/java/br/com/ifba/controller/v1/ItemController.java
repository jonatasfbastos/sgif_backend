package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.item.service.IServiceItem;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

public class ItemController {
    
    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServiceItem itemService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //


}
