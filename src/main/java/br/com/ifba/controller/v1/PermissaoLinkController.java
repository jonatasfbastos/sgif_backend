package br.com.ifba.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.permissaolink.dto.PermissaoLinkRequestDto;
import br.com.ifba.entity.permissaolink.model.PermissaoLink;
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

    /**
     * @author Andesson Reis
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza uma permissaoLink.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/permissoesLinks/permissoesLink", consumes = "application/json")
    public ResponseEntity<?> atualizarPermissaoLinks (@Valid @RequestBody PermissaoLinkRequestDto permissaoLinkDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(permissaoLinkService.updateLink(objectMapperUtil.map(permissaoLinkDto, PermissaoLink.class)));

    }

    /**
     * @author Andesson Reis
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva uma permissãoLink.
     * @return uma entidade de resposta generica.
     */

    @PostMapping(path = "/permissoesLinks/permissoesLink", consumes = "application/json")
    public ResponseEntity<?> salvarPermissao (@Valid @RequestBody PermissaoLinkRequestDto permissaoLinkDto, BindingResult result) {

        PermissaoLink permissaoLink = objectMapperUtil.map(permissaoLinkDto, PermissaoLink.class);
    
        return result.hasErrors()
            ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
            : ResponseEntity.status(HttpStatus.CREATED)
            .body(permissaoLinkService.saveLink(permissaoLink));
    }

}
