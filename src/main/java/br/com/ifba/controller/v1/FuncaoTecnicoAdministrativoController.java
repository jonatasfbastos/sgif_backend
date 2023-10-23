package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.funcaotecnicoadministrativo.service.IServiceFuncaoTecnicoAdministrativo;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar funções de técnico administrativo.
 *
 * @author Seu Nome
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.funcao_tecnico_administrativo.model.FuncaoTecnicoAdministrativo}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class FuncaoTecnicoAdministrativoController {

    @Autowired
    IServiceFuncaoTecnicoAdministrativo funcaoTecnicoAdministrativoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;
