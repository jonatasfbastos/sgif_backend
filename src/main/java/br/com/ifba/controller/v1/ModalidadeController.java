package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}