package br.com.ifba.controller.v1;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.aluno.dto.AlunoRequestDto;
import br.com.ifba.entity.aluno.model.Aluno;
import br.com.ifba.entity.aluno.service.IAlunoService;
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
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Lista todos os alunos cadastrados na base de dados.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/alunos", consumes = "application/json")
    public ResponseEntity<?> listarAlunos() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(alunoService.listarAlunos());

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Salva um aluno na base de dados.
     * @return uma entidade de resposta generica.
     */
    @PostMapping(path = "/cursos/curso", consumes = "application/json")
    public ResponseEntity<?> salvarAluno(@Valid @RequestBody AlunoRequestDto alunoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvarAluno(objectMapperUtil.map(alunoDto, Aluno.class)));
    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Atualiza um aluno.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/cursos/curso", consumes = "application/json")
    public ResponseEntity<?> atualizarAluno(@Valid @RequestBody AlunoRequestDto alunoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizarAluno(objectMapperUtil.map(alunoDto, Aluno.class)));

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * <p>
     * Deleta o aluno atrelado ao ID passado por parâmetro.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/cursos/curso/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarAlunoPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(alunoService.deletarAlunoPorId(id));

    }

}
