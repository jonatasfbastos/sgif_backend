package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.tipoturma.service.IServiceTipoTurma;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * Desde V1.0.1
 * 
 *Veja também: {@link br.com.ifba.entity.tipoturma.model.TipoTurma}
 */
@RestController
@RequestMapping(path = "/api/v1")
public class TipoTurmaController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServiceTipoTurma tipoTurmaService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * Obtém a lista de todos os Tipos de Turma.
     *
     * @return Uma lista de Tipos de Turma ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/tiposTurma", consumes = "application/json")
    public ResponseEntity<?> getTipoTurma() {
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoTurmaService.getAllTipoTurma());
    }
}
