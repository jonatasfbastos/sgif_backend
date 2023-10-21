package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.item.service.IServiceItem;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * Desde V1.0.1
 * 
 *Veja também: {@link br.com.ifba.entity.item.model.Item}
 */

@RestController
@RequestMapping(path = "/apif/v1")
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

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todos os itens.
     *
     * @return Uma lista de itens ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/itens", consumes = "application/json")
    public ResponseEntity<?> getItens() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.getAllItens());
    }

}
