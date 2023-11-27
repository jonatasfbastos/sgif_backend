package br.com.ifba.sgif.api.controller.v1;

import br.com.ifba.sgif.api.controller.v1.util.ResultError;
import br.com.ifba.sgif.api.entity.aluno.dto.AlunoRequestDto;
import br.com.ifba.sgif.api.entity.aluno.model.Aluno;
import br.com.ifba.sgif.api.entity.aluno.service.IAlunoService;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/apif/v1")
public class AlunoController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    private IAlunoService alunoService;
    @Autowired
    ObjectMapperUtil objectMapperUtil;


    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Lista todos os alunos cadastrados na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/alunos", produces = "application/json")
    public ResponseEntity<?> listarAlunos() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(alunoService.listarAlunos());

    }

    /**
     * Salva um aluno na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta generica.
     */
    @PostMapping(path = "/alunos/aluno", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarAluno(@Valid @RequestBody AlunoRequestDto alunoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvarAluno(objectMapperUtil.map(alunoDto, Aluno.class)));
    }

    /**
     * Atualiza um aluno.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/alunos/aluno", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> atualizarAluno(@Valid @RequestBody AlunoRequestDto alunoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizarAluno(objectMapperUtil.map(alunoDto, Aluno.class)));

    }

    /**
     * Deleta o aluno atrelado ao ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/alunos/aluno/{id}", produces = "application/json")
    public ResponseEntity<?> deletarAlunoPorId(@PathVariable("id") @NotNull Long id){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(alunoService.deletarAlunoPorId(id));

    }

}
