package br.com.ifba.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ifba.entity.permissaolink.service.IServicePermissaoLink;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

public class PermissaoLinkController {
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IServicePermissaoLink permissaoLinkService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todos os links de permissões.
     * 
     * @return Uma lista de links ou uma resposta de erro em caso de falha.
     *         
     * 
     * @author Andesson Reis
     */

    @GetMapping(path = "/listarLinks", consumes = "application/json")
    public ResponseEntity<?> listarLinks() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(permissaoLinkService.getAllLinks());
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todas as permissõesLinks por ID.
     *
     * @return Uma lista de permissõesLinks ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/listarLinksPermissao/{id}", consumes = "application/json")
    public ResponseEntity<?> listarPermissoesPorId(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(permissaoLinkService.getAllByPermissaoId(id));
    }

}
