package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.fornecedor.dto.FornecedorRequestDto;
import br.com.ifba.entity.fornecedor.model.Fornecedor;
import br.com.ifba.entity.fornecedor.service.IServiceFornecedor;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @apiNote Endpoint criado desde a versão 1.0.1
 *
 * Controller para gerenciar fornecedores.
 *
 * @author Andesson Reis
 * @since V1.0.1
 * 
 * Veja também: {@link br.com.ifba.entity.fornecedor.model.Fornecedor}
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class FornecedorController {

    @Autowired
    IServiceFornecedor fornecedorService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    /**
     * Obtém a lista de todos os fornecedores.
     * 
     * @return Uma lista de fornecedores ou uma resposta de erro em caso de falha.
     */
    @GetMapping(path = "/fornecedores", consumes = "application/json")
    public ResponseEntity<?> getFornecedores() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(fornecedorService.getAllFornecedores());
    }

    /**
     * Atualiza um fornecedor.
     * 
     * @return Uma entidade de resposta genérica.
     */
    @PutMapping(path = "/fornecedores/fornecedor", consumes = "application/json")
    public ResponseEntity<?> atualizarFornecedor(@Valid @RequestBody FornecedorRequestDto fornecedorDto, BindingResult result) {

        
        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(fornecedorService.updateFornecedor(objectMapperUtil.map(fornecedorDto, Fornecedor.class)));

    }
}