package br.com.ifba.controller.v1;


import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.etapacurso.dto.EtapaCursoRequestDto;
import br.com.ifba.entity.etapacurso.model.EtapaCurso;
import br.com.ifba.entity.etapacurso.service.IEtapaCursoService;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
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
 * @since Desde V1.0.1
 */
public class EtapaCursoController {


    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IEtapaCursoService etapaCursoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Lista todas as etapas de curso cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/etapascurso", produces = "application/json")
    public ResponseEntity<?> listarEtapasCurso() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.etapaCursoService.listarEtapasCurso());

    }

    /**
     * Busca uma etapa de curso na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID da etapa de curso a ser buscada.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/etapascurso/etapacurso/{id}", produces = "application/json")
    public ResponseEntity<?> encontrarEtapaCursoPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.etapaCursoService.encontrarEtapaCursoPorId(id));

    }

    /**
     * Salva uma etapa de curso na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param etapaCursoDto DTO com dados da etapa de curso a ser salva.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PostMapping(path = "/etapascurso/etapacurso", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarEtapaCurso(@Valid @RequestBody EtapaCursoRequestDto etapaCursoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this.etapaCursoService.salvarEtapaCurso(objectMapperUtil.map(etapaCursoDto, EtapaCurso.class)));

    }

    /**
     * Atualiza uma etapa de curso existente na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param etapaCursoDto DTO com dados da etapa de curso a ser atualizada.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PutMapping(path = "/etapascurso/etapacurso", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> atualizarEtapaCurso(@Valid @RequestBody EtapaCursoRequestDto etapaCursoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this.etapaCursoService.atualizarEtapaCurso(objectMapperUtil.map(etapaCursoDto, EtapaCurso.class)));

    }

    /**
     * Deleta uma etapa de curso na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID da etapa de curso a ser deletada.
     * @return uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/etapascurso/etapacurso{id}", produces = "application/json")
    public ResponseEntity<?> deletarEtapaCursoPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.etapaCursoService.deletarEtapaCursoPorId(id));

    }

}
