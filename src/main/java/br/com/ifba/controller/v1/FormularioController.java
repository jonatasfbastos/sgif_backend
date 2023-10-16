package br.com.ifba.controller.v1;

import br.com.ifba.controller.v1.util.ResultError;
import br.com.ifba.entity.formulario.dto.FormularioRequestDto;
import br.com.ifba.entity.formulario.model.Formulario;
import br.com.ifba.entity.formulario.service.IFormularioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Giovane Neves
 * Desde V1.0.1
 */
@RestController
@RequestMapping(path = "/apif/v1")
public class FormularioController {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    @Autowired
    IFormularioService formularioService;

    // =========================================================== //
    // =============== [        ENDPOINTS       ] ================ //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * @apiNote  Endpoint criado desde a versão 1.0.1
     *
     * Procura um formulário na base de dados pelo ID passado
     * como parâmetro da requisição.
     * @return um entidade de resposta generica.
     */
    @GetMapping(path = "/formularios/formulario/{id}", consumes = "application/json")
    public ResponseEntity<?> encontrarFormularioPorId(@PathVariable("id") Long id){

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(formularioService.encontrarFormularioPorId(id));

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva um formulário.
     * @return uma entidade de resposta generica.
     */
    @PostMapping(path = "/formularios/formulario", consumes = "application/json")
    public ResponseEntity<?> salvarFormulario(@RequestBody FormularioRequestDto formDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.CREATED).body(formularioService.salvarFormulario(Formulario.fromRequestDto(formDto)));
    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza um formulário.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/formularios/formulario", consumes = "application/json")
    public ResponseEntity<?> atualizarFormulario(@RequestBody FormularioRequestDto formDto, BindingResult result){

        return result.hasErrors()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultError.getResultErrors(result))
                : ResponseEntity.status(HttpStatus.OK).body(formularioService.atualizarFormulario(Formulario.fromRequestDto(formDto)));

    }

    /**
     * @author Giovane Neves
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Deleta o formulário atrelado ao ID passado por parâmetro.
     * @return uma entidade de resposta generica.
     */
    @DeleteMapping(path = "/formularios/formulario/{id}", consumes = "application/json")
    public ResponseEntity<?> deletarFormularioPorId(@PathVariable("id") Long id){

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(formularioService.deletarFormularioPorId(id));
    }


}
