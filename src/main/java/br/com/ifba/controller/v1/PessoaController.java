package br.com.ifba.controller.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.pessoa.dto.PessoaRequestDto;
import br.com.ifba.entity.pessoa.model.Pessoa;
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

    /**
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Obtém uma pessoa.
     *
     * @return Uma pessoa ou uma resposta de erro em caso de falha.
     *
     * @author Andesson Reis
     */
    @GetMapping(path = "/pessoa/{id}", consumes = "application/json")
    public ResponseEntity<?> getPessoa(@Valid @PathVariable("id") @NotNull UUID id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoaService.findById(id));
    }

      /**
     * @author Andesson Reis
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva uma pessoa.
     * @return uma entidade de resposta generica.
     */

    @PostMapping(path = "/pessoas/pessoa", consumes = "application/json")
    public ResponseEntity<?> salvarPessoa(@Valid @RequestBody PessoaRequestDto pessoaDto, BindingResult result) {

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED)
                        .body(pessoaService.savePessoa(objectMapperUtil.map(pessoaDto, Pessoa.class)));

    }

}
