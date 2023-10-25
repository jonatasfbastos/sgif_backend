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
import br.com.ifba.entity.tipoturma.model.TipoTurma;
import br.com.ifba.entity.tipoturma.service.IServiceTipoTurma;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * Desde V1.0.1
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
     * Atualiza um Tipo de Turma.
     *
     * @param tipoTurmaDto - O Tipo de Turma a ser atualizado.
     * @param result - Resultado da validação.
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(path = "/tipoTurma/tipoTurma", consumes = "application/json")
    public ResponseEntity<?> atualizarTipoTurma(@Valid @RequestBody TipoTurma tipoTurmaDto, BindingResult result) {
        
        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(tipoTurmaService.updateTipoTurma(objectMapperUtil.map(tipoTurmaDto, TipoTurma.class)));
    }
}
