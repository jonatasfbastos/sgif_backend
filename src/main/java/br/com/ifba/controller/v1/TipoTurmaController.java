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
import br.com.ifba.entity.tipoturma.model.TipoTurma;
import br.com.ifba.entity.tipoturma.service.IServiceTipoTurma;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar Tipos de Turma.
 *
 * @author Andesson reis
 * @since Desde V1.0.1
 * 
 *Veja também: {@link br.com.ifba.entity.tipoturma.model.TipoTurma}
 */
@RestController
@RequestMapping(path = "/api/v1")
public class TipoTurmaController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServiceTipoTurma tipoTurmaService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * 
     * Obtém a lista de todos os Tipos de Turma.
     *
     * @return Uma lista de Tipos de Turma ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/tiposTurma", consumes = "application/json")
    public ResponseEntity<?> getTipoTurma() {
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoTurmaService.getAllTipoTurma());
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * 
     * Atualiza um Tipo de Turma.
     *
     * @param tipoTurmaDto - O Tipo de Turma a ser atualizado.
     * @param result - Resultado da validação.
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(path = "/tiposTurma/tipoTurma", consumes = "application/json")
    public ResponseEntity<?> atualizarTipoTurma(@Valid @RequestBody TipoTurma tipoTurmaDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(tipoTurmaService.updateTipoTurma(objectMapperUtil.map(tipoTurmaDto, TipoTurma.class)));
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * 
     * Salva um Tipo de Turma.
     *
     * @param tipoTurmaDto - O Tipo de Turma a ser salvo.
     * @param result - Resultado da validação.
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/tiposTurma/tipoTurma", consumes = "application/json")
    public ResponseEntity<?> salvarTipoTurma(@Valid @RequestBody TipoTurma tipoTurmaDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(tipoTurmaService.saveTipoTurma(objectMapperUtil.map(tipoTurmaDto, TipoTurma.class)));
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * 
     * Deleta um Tipo de Turma com base no seu ID.
     *
     * @param id - O ID do Tipo de Turma a ser deletado.
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/tiposTurma/tipoTurma/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarTipoTurmaPorID(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(tipoTurmaService.deleteTipoTurma(id));
    }

}
