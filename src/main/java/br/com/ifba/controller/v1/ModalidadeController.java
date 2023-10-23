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
import br.com.ifba.entity.modalidade.dto.ModalidadeRequestDto;
import br.com.ifba.entity.modalidade.model.Modalidade;
import br.com.ifba.entity.modalidade.service.IServiceModalidade;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;
/**
 * @author Andesson Reis
 * @since Desde V1.0.1
 */
@RestController
@RequestMapping("/api/v1")
public class ModalidadeController {

    @Autowired
    IServiceModalidade modalidadeService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    /**
     * Obtém a lista de todas as modalidades.
     *
     * @return Uma lista de modalidades ou uma resposta de erro em caso de falha.
     */
    @GetMapping(consumes = "application/json")
    public ResponseEntity<?> getModalidades() {

        return ResponseEntity.status(HttpStatus.OK)
            .body(modalidadeService.getAllModalidade());
    }

        /**
     * Salva uma modalidade.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> salvarModalidade(@Valid @RequestBody ModalidadeRequestDto modalidadeDto, BindingResult result) {
        
        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(modalidadeService.saveModalidade(objectMapperUtil.map(modalidadeDto, Modalidade.class)));
    }

}