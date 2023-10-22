package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.empenho.service.IServiceEmpenho;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar empenhos.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.empenho.model.Empenho}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class EmpenhoController {

    @Autowired
    IServiceEmpenho empenhoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    /**
     * Obtém a lista de todos os empenhos.
     *
     * @return Uma lista de empenhos ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/empenhos", consumes = "application/json")
    public ResponseEntity<?> getEmpenhos() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(empenhoService.getAllEmpenho());
    }
}