package br.com.ifba.controller.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.entity.pessoa.service.IServicePessoa;
import br.com.ifba.infrastructure.util.ObjectMapperUtil;

/**
 * @author Andesson reis
 * Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class PessoaController {
        // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    @Autowired
    IServicePessoa pessoaService;

    @Autowired
    ObjectMapperUtil objectMapperUtil;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém a lista de todos as pessoas.
     * 
     * @return Uma lista de pessoas ou uma resposta de erro em caso de falha.
     * 
     * @author Andesson Reis
     */
    @GetMapping(path = "/pessoas", consumes = "application/json")
    public ResponseEntity<?> getPessoas() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoaService.getAllPessoas());
    }

      /**
     * @author Andesson Reis
     * Desde V1.0.1
     * 
     * Encontra Pessoas pelo nome.
     *
     * @param name O nome a ser pesquisado.
     * @return Uma lista de Pessoas com o nome especificado ou uma resposta de erro em caso de falha
     *        
     */
    @GetMapping(path = "/pessoas/pessoas", consumes = "application/json")
    public ResponseEntity<?> getPessoasPorNome(@Valid @PathVariable String nome) {
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoaService.findByNome(nome));
   
    }
}
