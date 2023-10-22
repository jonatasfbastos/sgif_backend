package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.empenho.dto.EmpenhoRequestDto;
import br.com.ifba.entity.empenho.model.Empenho;
import br.com.ifba.entity.empenho.service.IServiceEmpenho;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar empenhos.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.empenho.model.Empenho}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class EmpenhoController {

    @Autowired
    IServiceEmpenho empenhoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    /**
     * Obtém a lista de todos os empenhos.
     *
     * @return Uma lista de empenhos ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/empenhos", consumes = "application/json")
    public ResponseEntity<?> getEmpenhos() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(empenhoService.getAllEmpenho());
    }

     /**
     * Atualiza um empenho.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(path = "/empenhos/empenho", consumes = "application/json")
    public ResponseEntity<?> atualizarEmpenho(@Valid @RequestBody EmpenhoRequestDto empenhoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(empenhoService.updateEmpenho(objectMapperUtil.map(empenhoDto, Empenho.class)));
    }

   
}