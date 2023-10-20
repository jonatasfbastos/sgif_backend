package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.permissao.service.IServicePermissao;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;


/**
 * 
 * 
 * @author Andesson reis
 * Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
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
    // =========================================================== //

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todas as permissões.
     * 
     * @return Uma lista de permissoes ou uma resposta de erro em caso de falha.
     *         
     * 
     * @author Andesson Reis
     */

    @GetMapping(path = "/permissoes", consumes = "application/json")
    public ResponseEntity<?> listarPermissoes() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(permissaoService.getAllPermissoes());
    }


}