package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.tipodeitem.service.ITipoDeItemService;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar tipos de item.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.tipoitem.model.TipoDeItem}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class TipoDeItemController {
    
    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    ITipoDeItemService tipoDeItemService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * Obtém a lista de todos os tipos de item.
     *
     * @return Uma lista de tipos de item ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/tiposdeitem", consumes = "application/json")
    public ResponseEntity<?> getTiposDeItem() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoDeItemService.getAllTiposDeItem());
    }
}

