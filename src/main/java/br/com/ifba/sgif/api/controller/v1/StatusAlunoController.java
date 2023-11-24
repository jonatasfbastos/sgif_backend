package br.com.ifba.sgif.api.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.ifba.sgif.api.controller.v1.util.ResultError;
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

import br.com.ifba.sgif.api.entity.statusaluno.dto.StatusAlunoRequestDto;
import br.com.ifba.sgif.api.entity.statusaluno.model.StatusAluno;
import br.com.ifba.sgif.api.entity.statusaluno.service.IServiceStatusAluno;
import br.com.ifba.sgif.api.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar Status dos Alunos.
 *
 * @author Andesson Reis
 * @since V1.0.1
 */
@RestController
@RequestMapping(path = "/api/v1")
public class StatusAlunoController {

    @Autowired
    private IServiceStatusAluno statusAlunoService;

    @Autowired
    private ObjectMapperUtil objectMapperUtil;

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * Obtém a lista de todos os Status dos Alunos.
     * 
     * @return Uma lista de Status dos Alunos ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/statusAlunos", consumes = "application/json")
    public ResponseEntity<?> getStatusAlunos() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(statusAlunoService.getAllstatus());
    }

        /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * Atualiza um Status do Aluno.
     * 
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(path = "/statusAlunos/statusAluno", consumes = "application/json")
    public ResponseEntity<?> atualizarStatusAluno(@Valid @RequestBody StatusAlunoRequestDto statusAlunoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(statusAlunoService.updateStatus(objectMapperUtil.map(statusAlunoDto, StatusAluno.class)));
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * Salva um Status do Aluno.
     * 
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/statusAlunos/statusAluno", consumes = "application/json")
    public ResponseEntity<?> salvarStatusAluno(@Valid @RequestBody StatusAlunoRequestDto statusAlunoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(statusAlunoService.saveStatus(objectMapperUtil.map(statusAlunoDto, StatusAluno.class)));
    }

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     * Deleta um Status do Aluno com base no ID.
     * 
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/statusAlunos/statusAluno/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarStatusAlunoPorID(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(statusAlunoService.deleteStatus(id));
    }
    
}
