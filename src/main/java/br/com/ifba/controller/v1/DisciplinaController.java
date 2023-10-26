package br.com.ifba.controller.v1;

import br.com.ifba.entity.avaliacao.service.IAvaliacaoService;
import br.com.ifba.entity.disciplina.service.IDisciplinaService;
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
 * @since Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class DisciplinaController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IDisciplinaService disciplinaService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Lista todas as disciplinas na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/disciplinas", produces = "application/json")
    public ResponseEntity<?> listarDisciplinas() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.disciplinaService.listarDisciplinas());

    }

    /**
     * Busca uma disciplina na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID da disciplina a ser buscada.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/disciplinas/disciplina/{id}", produces = "application/json")
    public ResponseEntity<?> encontrarDisciplinaPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.disciplinaService.encontrarDisciplinaPorId(id));

    }

}