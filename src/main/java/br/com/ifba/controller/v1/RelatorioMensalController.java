package br.com.ifba.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.relatoriomensal.dto.RelatorioMensalRequestDto;
import br.com.ifba.entity.relatoriomensal.model.RelatorioMensal;
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

    /**
     * Salva um relatório mensal.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/relatorios-mensais/relatorio-mensal", consumes = "application/json")
    public ResponseEntity<?> salvarRelatorioMensal(@Valid @RequestBody RelatorioMensalRequestDto relatorioMensalDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(relatorioMensalService.saveRelatorioMensal(objectMapperUtil.map(relatorioMensalDto, RelatorioMensal.class)));
    }

    /**
     * Deleta um relatório mensal com base no seu ID.
     *
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/relatorios-mensais/relatorio-mensal/{id}", consumes = "application.json")
    public ResponseEntity<?> deletarRelatorioMensalPorID(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(relatorioMensalService.delete(id));
    }
}
