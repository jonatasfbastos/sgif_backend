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
import br.com.ifba.entity.funcaoservidor.dto.FuncaoServidorRequestDto;
import br.com.ifba.entity.funcaoservidor.model.FuncaoServidor;
import br.com.ifba.entity.funcaoservidor.service.IServiceFuncaoServidor;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar funções de servidor.
 *
 * @author Andesson Reis
 * @since V1.0.1
 *
 * Veja também: {@link br.com.ifba.entity.funcao_servidor.model.FuncaoServidor}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class FuncaoServidorController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IServiceFuncaoServidor funcaoServidorService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;


    // =========================================================== //
    // =============== [         ENDPOINTS      ] ================ //
    // =========================================================== //
    
    /**
     * Obtém a lista de todas as funções de servidor.
     *
     * @return Uma lista de funções de servidor ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/funcoesServidor", consumes = "application/json")
    public ResponseEntity<?> getFuncoesServidor() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(funcaoServidorService.getAllFuncaoServidor());
    }

    /**
     * Salva uma função de servidor.
     *
     * @return Uma entidade de resposta genérica.
     */
    @PostMapping(path = "/funcoesServidor/funcaoServidor", consumes = "application/json")
    public ResponseEntity<?> salvarFuncaoServidor(@Valid @RequestBody FuncaoServidorRequestDto funcaoServidorDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(funcaoServidorService.saveFuncaoServidor(objectMapperUtil.map(funcaoServidorDto, FuncaoServidor.class)));
    }

}
