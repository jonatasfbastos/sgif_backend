package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.requisicao.service.IServiceRequisicao;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * @since V1.0.1
 * 
 *Veja também: {@link br.com.ifba.entity.requisicao.model.Requisicao}
 */

@RestController
@RequestMapping(path = "/apif/v1")
public class RequisicaoController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    @Autowired
    IServiceRequisicao requisicaoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todos as requisicao.
     * 
     * @return Uma lista de requisicao ou uma resposta de erro em caso de falha.
     * 
     * @author Andesson Reis
     */
    @GetMapping(path = "/requisicoes", consumes = "application/json")
    public ResponseEntity<?> getRequisicoes() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(requisicaoService.getAllRequisicao());
    }
}
