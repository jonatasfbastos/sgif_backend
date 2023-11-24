package br.com.ifba.sgif.api.controller.v1;

import br.com.ifba.sgif.api.controller.v1.util.ResultError;
import br.com.ifba.sgif.api.entity.turma.dto.TurmaRequestDto;
import br.com.ifba.sgif.api.entity.turma.model.Turma;
import br.com.ifba.sgif.api.entity.turma.service.ITurmaService;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Giovane Neves
 * @since Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class TurmaController {


    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private ITurmaService turmaService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;


    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Lista todas as turmas cadastradas na base de dados.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/turmas", consumes = "application/json")
    public ResponseEntity<?> listarTurmas() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(turmaService.listarTurmas());

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Salva uma turma na base de dados.
     * @return uma entidade de resposta generica.
     */
    @PostMapping(path = "/turmas/turma", consumes = "application/json")
    public ResponseEntity<?> salvarTurma(@Valid @RequestBody TurmaRequestDto turmaDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(turmaService.salvarTurma(objectMapperUtil.map(turmaDto, Turma.class)));
    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Atualiza uma turma.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/turmas/turma", consumes = "application/json")
    public ResponseEntity<?> atualizarTurma(@Valid @RequestBody TurmaRequestDto turmaDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(turmaService.atualizarTurma(objectMapperUtil.map(turmaDto, Turma.class)));

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Deleta a turma atrelada ao ID passado por parâmetro.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/turmas/turma/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarTurmaPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(turmaService.deletarTurmaPorId(id));

    }

}
