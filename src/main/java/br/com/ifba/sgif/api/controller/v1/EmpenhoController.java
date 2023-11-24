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

import br.com.ifba.sgif.api.entity.empenho.dto.EmpenhoRequestDto;
import br.com.ifba.sgif.api.entity.empenho.model.Empenho;
import br.com.ifba.sgif.api.entity.empenho.service.IServiceEmpenho;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar empenhos.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link Empenho}
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

    /**
     * Salva um empenho.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/empenhos/empenho", consumes = "application/json")
    public ResponseEntity<?> salvarEmpenho(@Valid @RequestBody EmpenhoRequestDto empenhoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(empenhoService.saveEmpenho(objectMapperUtil.map(empenhoDto, Empenho.class)));
    }


    /**
     * Deleta um empenho com base no seu ID.
     *
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/empenhos/empenho/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarEmpenhoPorID(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(empenhoService.deleteEmpenho(id));
    }

   
}