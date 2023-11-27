package br.com.ifba.sgif.api.controller.v1;

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

import br.com.ifba.sgif.api.entity.requisicao.dto.RequisicaoRequestDto;
import br.com.ifba.sgif.api.entity.requisicao.model.Requisicao;
import br.com.ifba.sgif.api.entity.requisicao.service.IServiceRequisicao;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * @since V1.0.1
 * 
 *Veja também: {@link Requisicao}
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
     * Obtém a lista de todos as requisição.
     * 
     * @return Uma lista de requisições ou uma resposta de erro em caso de falha.
     * 
     * @author Andesson Reis
     */
    @GetMapping(path = "/requisicoes", consumes = "application/json")
    public ResponseEntity<?> getRequisicoes() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(requisicaoService.getAllRequisicao());
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza uma requisição.
     * 
     * @return uma entidade de resposta generica.
     * 
     * @author Andesson Reis
     */
    @PutMapping(path = "/requisicoes/requisicao", consumes = "application/json")
    public ResponseEntity<?> atualizarRequisicao(@Valid @RequestBody RequisicaoRequestDto reqDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(requisicaoService.updateRequisicao(objectMapperUtil.map(reqDto, Requisicao.class)));

    }

    /**
     * @author Andesson Reis
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva uma requisição.
     * @return uma entidade de resposta generica.
     */

    @PostMapping(path = "/requisicoes/requisicao", consumes = "application/json")
    public ResponseEntity<?> salvarRequisicao(@Valid @RequestBody RequisicaoRequestDto reqDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED)
                        .body(requisicaoService.saveRequisicao(objectMapperUtil.map(reqDto, Requisicao.class)));

    }

    /**
     * @author Andesson Reis
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Deleta uma requisição.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/requisicoes/requisicao/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarRequisicaoPorID(@Valid @PathVariable("id") @NotNull Long id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(requisicaoService.deleteRequisicao(id));
    }

}
