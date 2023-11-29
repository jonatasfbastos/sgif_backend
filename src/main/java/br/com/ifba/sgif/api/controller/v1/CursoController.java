package br.com.ifba.sgif.api.controller.v1;

import br.com.ifba.sgif.api.controller.v1.util.ResultError;
import br.com.ifba.sgif.api.entity.curso.dto.CursoRequestDto;
import br.com.ifba.sgif.api.entity.curso.model.Curso;
import br.com.ifba.sgif.api.entity.curso.service.ICursoService;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class CursoController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    @Autowired
    ICursoService cursoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Lista todos os cursos cadastrados na base de dados.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/cursos", consumes="application/json")
    public ResponseEntity<?> listarCursos(){

        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.listarCursos());

    }

    /**
     * @author Giovane Neves
     * @apiNote  Endpoint criado desde a versão 1.0.1
     *
     * Procura um curso na base de dados pelo ID passado
     * como parâmetro da requisição.
     * @return uma entidade de resposta generica.
     */
    @GetMapping(path = "/cursos/curso/{id}", consumes = "application/json")
    public ResponseEntity<?> encontrarCursoPorId(@PathVariable("id") @NotNull Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.encontrarCursoPorId(id));

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva um curso na base de dados.
     * @return uma entidade de resposta generica.
     */
    @PostMapping(path = "/cursos/curso", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarCurso(@Valid @RequestBody CursoRequestDto cursoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(cursoService.salvarCurso(objectMapperUtil.map(cursoDto, Curso.class)));
    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza um curso.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/cursos/curso", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> atualizarCurso(@Valid @RequestBody CursoRequestDto cursoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(cursoService.atualizarCurso(objectMapperUtil.map(cursoDto, Curso.class)));

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Deleta o curso atrelado ao ID passado por parâmetro.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/cursos/curso/{id}", produces = "application/json")
    public ResponseEntity<?> deletarCursoPorId(@PathVariable("id") @NotNull Long id){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(cursoService.deletarCursoPorId(id));
    }

}
