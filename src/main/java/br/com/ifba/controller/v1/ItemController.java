package br.com.ifba.controller.v1;

import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.item.service.IServiceItem;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 *         Desde V1.0.1
 * 
 *         Veja também: {@link br.com.ifba.entity.item.model.Item}
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

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém um item por ID.
     *
     * @param id O ID do item a ser obtido.
     * @return Um item ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/item/{id}", consumes = "application/json")
    public ResponseEntity<?> getItem(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.getItemById(id));
    }

    /**
    * @apiNote Endpoint criado desde a versão 1.0.1
    *
    * Obtém um item por nome.
    *
    * @param nome O nome do item a ser obtido.
    * @return Um item ou uma resposta de erro em caso de falha.
    *
    * @author Andesson Reis
    */
    @GetMapping(path = "/itens/item", consumes = "application/json")
    public ResponseEntity<?> getItemPorNome(@Valid @PathVariable String nome) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.findByNome(nome));
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém uma lista de itens cuja data não seja anterior à data fornecida.
     *
     * @param dataNot A data de referência para filtrar os itens.
     * @return Uma lista de itens ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/itens/dataNotBefore", consumes = "application/json")
    public ResponseEntity<?> findByDataNotBefore(@Valid @PathVariable Date dataNot) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.findByDataNotBefore(dataNot));
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém uma lista de itens cuja data de validade seja posterior à data fornecida.
     *
     * @param validade A data de referência para filtrar os itens.
     * @return Uma lista de itens ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/itens/validadeAfter", consumes = "application/json")
    public ResponseEntity<?> findByValidadeAfter(@Valid @PathVariable Date validade) {

         return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.findByValidadeAfter(validade));
    }


}
