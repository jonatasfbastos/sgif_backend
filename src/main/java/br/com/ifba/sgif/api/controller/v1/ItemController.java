package br.com.ifba.sgif.api.controller.v1;

import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.ifba.sgif.api.controller.v1.util.ResultError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.sgif.api.entity.item.dto.ItemRequestDto;
import br.com.ifba.sgif.api.entity.item.model.Item;
import br.com.ifba.sgif.api.entity.item.service.IServiceItem;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * Desde V1.0.1
 * 
 * Veja também: {@link Item}
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
    public ResponseEntity<?> getItem(@Valid @PathVariable("id") @NotNull Long id) {

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

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza um item com os dados fornecidos.
     *
     * @param itemDto Os dados do item a ser atualizado.
     * @param result O resultado da validação dos dados do item.
     * @return O item atualizado ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @PutMapping(path = "/itens/item", consumes = "application/json")
    public ResponseEntity<?> atualizarItem(@Valid @RequestBody ItemRequestDto itemDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(itemService.updateItem(objectMapperUtil.map(itemDto, Item.class)));

    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva um novo item com os dados fornecidos.
     *
     * @param itemDto Os dados do item a ser salvo.
     * @param result O resultado da validação dos dados do item.
     * @return O item salvo ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @PostMapping(path = "/itens/item", consumes = "application/json")
    public ResponseEntity<?> salvarItem(@Valid @RequestBody ItemRequestDto itemDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(itemService.saveItem(objectMapperUtil.map(itemDto, Item.class)));

    }
    
    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Deleta um item por ID.
     *
     * @param id O ID do item a ser excluído.
     * @return Uma resposta de aceitação (202 Accepted) em caso de sucesso ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @DeleteMapping(path = "/Itens/Item/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarItemPorId(@PathVariable("id") @NotNull Long id){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(itemService.deleteItem(id));
    }


}
