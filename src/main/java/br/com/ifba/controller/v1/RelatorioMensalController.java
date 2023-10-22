package br.com.ifba.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ifba.entity.relatoriomensal.service.IServiceRelatorioMensal;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar relatórios mensais.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.relatorioMensal.model.RelatorioMensal}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class RelatorioMensalController {
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IServiceRelatorioMensal relatorioMensalService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //

    /**
     * Obtém a lista de todos os relatórios mensais.
     *
     * @return Uma lista de relatórios mensais ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/relatorios-mensais", consumes = "application/json")
    public ResponseEntity<?> getRelatoriosMensais() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(relatorioMensalService.getAllRelatorioMensal());
    }
}
