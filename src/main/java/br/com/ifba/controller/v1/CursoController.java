package br.com.ifba.controller.v1;

import br.com.ifba.entity.curso.service.ICursoService;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> encontrarCursoPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.encontrarCursoPorId(id));

    }

}
