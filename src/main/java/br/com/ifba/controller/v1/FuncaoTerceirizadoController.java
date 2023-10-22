package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.funcaoterceirizado.service.IServiceFuncaoTerceirizado;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

@RestController
@RequestMapping(path = "/apif/v1")
public class FuncaoTerceirizadoController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServiceFuncaoTerceirizado serviceFuncaoTerceirizado;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //
}
