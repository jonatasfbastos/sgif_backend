package br.com.ifba.controller.v1;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.avaliacao.dto.AvaliacaoRequestDto;
import br.com.ifba.entity.avaliacao.model.Avaliacao;
import br.com.ifba.entity.avaliacao.service.IAvaliacaoService;
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
public class AvaliacaoController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IAvaliacaoService avaliacaoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Lista todas as turmas cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/avaliacoes", produces = "application/json")
    public ResponseEntity<?> listarAvaliacoes() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.avaliacaoService.listarAvaliacoes());

    }

    /**
     * Busca uma avaliação na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID da avaliação a ser buscada.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/avaliacoes/avaliacao/{id}", produces = "application/json")
    public ResponseEntity<?> encontrarAvaliacaoPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.avaliacaoService.encontrarAvaliacaoPorId(id));

    }

    /**
     * Salva uma avaliação na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param avaliacaoDto DTO com dados da avaliação a ser salva.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PostMapping(path = "/avaliacoes/avaliacao", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarAvaliacao(@Valid @RequestBody AvaliacaoRequestDto avaliacaoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this.avaliacaoService.salvarAvaliacao(objectMapperUtil.map(avaliacaoDto, Avaliacao.class)));

    }

    /**
     * Atualiza uma avaliação existente na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param avaliacaoDto DTO com dados da avaliação a ser atualizada.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PutMapping(path = "/avaliacoes/avaliacao", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> atualizarAvaliacao(@Valid @RequestBody AvaliacaoRequestDto avaliacaoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this.avaliacaoService.atualizarAvaliacao(objectMapperUtil.map(avaliacaoDto, Avaliacao.class)));

    }

    /**
     * Deleta uma avaliação na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID da avaliação a ser deletada.
     * @return uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/avaliacoes/avaliacao/{id}", produces = "application/json")
    public ResponseEntity<?> deletarAvaliacaoPorId(@PathVariable("id") @NotNull UUID id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.avaliacaoService.deletarAvaliacaoPorId(id));

    }
}
