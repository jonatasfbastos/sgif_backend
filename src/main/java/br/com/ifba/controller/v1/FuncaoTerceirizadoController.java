package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.funcaoterceirizado.service.IServiceFuncaoTerceirizado;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar funções de terceirizados.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.funcaoterceirizado.model.FuncaoTerceirizado}
 */

@RestController
@RequestMapping(path = "/apif/v1")
public class FuncaoTerceirizadoController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServiceFuncaoTerceirizado funcaoTerceirizadoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * Obtém a lista de todas as funções de terceirizados.
     *
     * @return Uma lista de funções de terceirizados ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/funcoes-terceirizados", consumes = "application/json")
    public ResponseEntity<?> getFuncoesTerceirizados() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(funcaoTerceirizadoService.getAllFuncoesTerceirizado());
    }

}
