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
import br.com.ifba.entity.funcaoterceirizado.dto.FuncaoTerceirizadoRequestDto;
import br.com.ifba.entity.funcaoterceirizado.model.FuncaoTerceirizado;
import br.com.ifba.entity.funcaoterceirizado.service.IServiceFuncaoTerceirizado;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar funções de terceirizados.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.funcaoterceirizado.model.FuncaoTerceirizado}
 */

@RestController
@RequestMapping(path = "/apif/v1")
public class FuncaoTerceirizadoController {

    // =========================================================== //
    // =============== [ ATRIBUTOS ] ============================= //
    // =========================================================== //
    @Autowired
    IServiceFuncaoTerceirizado funcaoTerceirizadoService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [ ENDPOINTS ] ============================= //
    // =========================================================== //

    /**
     * Obtém a lista de todas as funções de terceirizados.
     *
     * @return Uma lista de funções de terceirizados ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/funcoes-terceirizados", consumes = "application/json")
    public ResponseEntity<?> getFuncoesTerceirizados() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(funcaoTerceirizadoService.getAllFuncoesTerceirizado());
    }

    /**
     * Salva uma função de terceirizado.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/funcoes-terceirizados/funcao-terceirizado", consumes = "application/json")
    public ResponseEntity<?> salvarFuncaoTerceirizado(@Valid @RequestBody FuncaoTerceirizadoRequestDto funcaoTerceirizadoDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(funcaoTerceirizadoService.saveFuncaoTerceirizado(objectMapperUtil.map(funcaoTerceirizadoDto, FuncaoTerceirizado.class)));
    }

    /**
     * Deleta uma função de terceirizado com base no seu ID.
     *
     * @return Uma entidade de resposta genérica.
     */
    @DeleteMapping(path = "/funcoes-terceirizados/funcao-terceirizado/{id}", consumes = "application.json")
    public ResponseEntity<?> deletarFuncaoTerceirizadoPorID(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(funcaoTerceirizadoService.deleteFuncaoTerceirizado(id));
    }

}
