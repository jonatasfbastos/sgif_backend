package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.matrizcurricular.dto.MatrizCurricularRequestDto;
import br.com.ifba.entity.matrizcurricular.model.MatrizCurricular;
import br.com.ifba.entity.matrizcurricular.service.IServiceMatrizCurricular;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar Matriz curricular .
 *
 * @author Andesson Reis
 * @since V1.0.1
 */
@RestController
@RequestMapping("/api/v1")
public class MatrizCurricularController {
    @Autowired
    IServiceMatrizCurricular matrizCurricularService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    /**
     * Obtém a lista de todas as matrizes curriculares.
     *
     * @return Uma lista de matrizes curriculares ou uma resposta de erro em caso de falha.
     */
    @GetMapping(consumes = "application/json")
    public ResponseEntity<?> getMatrizesCurriculares() {

        return ResponseEntity.status(HttpStatus.OK)
            .body(matrizCurricularService.getAllMatrizCurricular());
    }

    /**
     * Salva uma matriz curricular.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> salvarMatrizCurricular(@Valid @RequestBody MatrizCurricularRequestDto matrizCurricularDto, BindingResult result) {
        
        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(matrizCurricularService.saveMatrizCurricular(objectMapperUtil.map(matrizCurricularDto, MatrizCurricular.class)));
    }
}
