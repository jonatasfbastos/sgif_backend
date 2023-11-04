package br.com.ifba.controller.v1;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.professor.dto.ProfessorPostRequestDto;
import br.com.ifba.entity.professor.dto.ProfessorRequestDto;
import br.com.ifba.entity.professor.model.Professor;
import br.com.ifba.entity.professor.service.IProfessorService;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

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
public class ProfessorController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IProfessorService _professorService;

    @Autowired
    private ObjectMapperUtil _objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Lista todas os professores cadastrados na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/professores", produces = "application/json")
    public ResponseEntity<?> listarProfessores() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(this._professorService.listarProfessores());

    }


    /**
     * Busca um professor cadastrado na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID do professor a ser buscada.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/professores/professor/{id}", produces = "application/json")
    public ResponseEntity<?> encontrarProfessorPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this._professorService.encontrarProfessorPorId(id));

    }

    /**
     * Salva um professor na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param professorDto DTO com dados do professor a ser salvo.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PostMapping(path = "/professores/professor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarProfessor(@Valid @RequestBody ProfessorPostRequestDto professorDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this._professorService.salvarProfessor(_objectMapperUtil.map(professorDto, Professor.class)));

    }

    /**
     * Atualiza um professor existente na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param prfessorDto DTO com dados do professor a ser atualizado.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PutMapping(path = "/professores/professor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> atualizarProfessor(@Valid @RequestBody ProfessorRequestDto professorDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this._professorService.atualizarProfessor(_objectMapperUtil.map(professorDto, Professor.class)));

    }

    /**
     * Deleta um professsor existente na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID do professor a ser deletada.
     * @return uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/professores/professor/{id}", produces = "application/json")
    public ResponseEntity<?> deletarProfessorPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this._professorService.deletarProfessorPorId(id));

    }

}
