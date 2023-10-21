package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.fornecedor.service.IServiceFornecedor;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar fornecedores.
 *
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Veja também: {@link br.com.ifba.entity.fornecedor.model.Fornecedor}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class FornecedorController {

    @Autowired
    IServiceFornecedor fornecedorService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

}
