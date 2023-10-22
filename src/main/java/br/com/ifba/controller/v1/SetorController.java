package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.setor.service.IServiceSetor;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar setores.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.setor.model.Setor}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class SetorController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //

    @Autowired
    IServiceSetor setorService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //


    /**
     * Obtém a lista de todos os setores.
     *
     * @return Uma lista de setores ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/setores", consumes = "application/json")
    public ResponseEntity<?> getSetores() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(setorService.getAllSetor());
    }
}
