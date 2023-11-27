package br.com.ifba.sgif.api.controller.v1;

import br.com.ifba.sgif.api.controller.v1.util.ResultError;
import br.com.ifba.sgif.api.entity.questao.dto.QuestaoRequestDto;
import br.com.ifba.sgif.api.entity.questao.model.Questao;
import br.com.ifba.sgif.api.entity.questao.service.IQuestaoService;
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
public class QuestaoController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IQuestaoService questaoService;
    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Lista todas as questões cadastradas na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/questoes", produces = "application/json")
    public ResponseEntity<?> listarQuestoes() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.questaoService.listarQuestoes());

    }

    /**
     * Busca uma questão na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID da questão a ser buscada.
     * @return uma entidade de resposta genérica.
     */
    @GetMapping(path = "/questoes/questao/{id}", produces = "application/json")
    public ResponseEntity<?> encontrarQuestaoPorId(@PathVariable("id") @NotNull Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.questaoService.encontrarQuestaoPorId(id));

    }

    // TODO: Criar endpoint para enncontrar questões por enunciado.
    // TODO: Se for via PathVariable, terá que haver uma lógica de decodificação. Exemplo: (questoes/questao/qual-sua-opiniao-sobre-a-disciplina)

    /**
     * Salva uma questão na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param questaoDto DTO com dados da questão a ser salva.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PostMapping(path = "/questoes/questao", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> salvarQuestao(@Valid @RequestBody QuestaoRequestDto questaoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this.questaoService.salvarQuestao(objectMapperUtil.map(questaoDto, Questao.class)));

    }

    /**
     * Atualiza uma questão existente na base de dados.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param questaoDto DTO com dados da questão a ser atualizada.
     * @param result Resultado da requisição HTTP.
     * @return uma entidade de resposta genérica.
     */
    @PutMapping(path = "/questoes/questao", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> atualizarQuestao(@Valid @RequestBody QuestaoRequestDto questaoDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(this.questaoService.atualizarQuestao(objectMapperUtil.map(questaoDto, Questao.class)));

    }

    /**
     * Deleta uma questão na base de dados pelo ID passado por parâmetro.
     *
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     * @param id O ID da questão a ser deletada.
     * @return uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/questoes/questao/{id}", produces = "application/json")
    public ResponseEntity<?> deletarQuestaoPorId(@PathVariable("id") @NotNull Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(this.questaoService.deletarQuestaoPorId(id));

    }

}
