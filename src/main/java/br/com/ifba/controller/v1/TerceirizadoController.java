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
import br.com.ifba.entity.terceirizado.dto.TerceirizadoRequestDto;
import br.com.ifba.entity.terceirizado.model.Terceirizado;
import br.com.ifba.entity.terceirizado.service.IServiceTerceirizado;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar terceirizados.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.terceirizado.model.Terceirizado}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class TerceirizadoController {
    
    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    @Autowired
    IServiceTerceirizado terceirizadoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //

    /**
     * Obtém a lista de todos os terceirizados.
     *
     * @return Uma lista de terceirizados ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/terceirizados", consumes = "application/json")
    public ResponseEntity<?> getTerceirizados() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(terceirizadoService.getAllTerceirizados());
    }

    
    /**
     * Salva um terceirizado.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/terceirizados/terceirizado", consumes = "application/json")
    public ResponseEntity<?> salvarTerceirizado(@Valid @RequestBody TerceirizadoRequestDto terceirizadoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(terceirizadoService.saveTerceirizado(objectMapperUtil.map(terceirizadoDto, Terceirizado.class)));
    }
}
