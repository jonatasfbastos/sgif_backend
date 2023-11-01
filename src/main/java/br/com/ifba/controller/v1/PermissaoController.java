package br.com.ifba.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.permissao.dto.PermissaoRequestDto;
import br.com.ifba.entity.permissao.model.Permissao;
import br.com.ifba.entity.permissao.service.IServicePermissao;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;


/**
 * @author Andesson reis
 * Desde V1.0.1
 * 
 *Veja também: {@link br.com.ifba.entity.permissao.model.Permissao}
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

    @GetMapping(path = "/permissoes", produces = "application/json")
    public ResponseEntity<?> listarPermissoes() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(permissaoService.getAllPermissoes());
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todas as permissões por ID.
     *
     * @return Uma lista de permissoes ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/permissoes/{id}", produces = "application/json")
    public ResponseEntity<?> listarPermissoesPorId(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(permissaoService.getAllByPerfilId(id));
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todas as permissões por Link ID.
     *
     * @return Uma lista de permissoes ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/permissoes/permissao/link/{id}", produces = "application/json")
    public ResponseEntity<?> listarPermissoesPorLinkId(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(permissaoService.getAllByLinkId(id));
    }

    /**
     * @author Andesson Reis
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza uma permissao.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/permissoes/permissao", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> atualizarPermissao(@Valid @RequestBody PermissaoRequestDto permissaoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(permissaoService.updatePermissao(objectMapperUtil.map(permissaoDto, Permissao.class)));

    }

    /**
     * @author Andesson Reis
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva uma permissão.
     * @return uma entidade de resposta generica.
     */

    @PostMapping(path = "/permissoes/permissao", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarPermissao (@Valid @RequestBody PermissaoRequestDto permissaoDto, BindingResult result) {

        Permissao permissao = objectMapperUtil.map(permissaoDto, Permissao.class);
    
        return result.hasErrors()
            ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
            : ResponseEntity.status(HttpStatus.CREATED)
            .body(permissaoService.savePermissao(permissao));
    }

    /**
     * @author Andesson Reis
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Deleta uma permissão.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/permissoes/permissao/{id}", produces = "application/json")
    public ResponseEntity<?> deletarPermissaoPorId (@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(permissaoService.deletePermissao(id));
    }
    

}
