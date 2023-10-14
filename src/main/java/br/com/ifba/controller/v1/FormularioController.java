package br.com.ifba.controller.v1;

import br.com.ifba.entity.formulario.dto.FormularioRequestDto;
import br.com.ifba.entity.formulario.model.Formulario;
import br.com.ifba.entity.formulario.service.IFormularioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Salva um formulário.
     * @return uma entidade de resposta generica.
     */
    @PostMapping(path = "/formularios/formulario")
    public ResponseEntity<?> salvarFormulario(@RequestBody FormularioRequestDto formDto, BindingResult result){

        if(result.hasErrors()){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResultErrors(result));

        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(formularioService.salvarFormulario(Formulario.fromRequestDto(formDto)));
    }

    /**
     * @author Giovane Neves
     *
     * @apiNote Endpoint criado desde a versão 1.0.1
     *
     * Atualiza um formulário.
     * @return uma entidade de resposta generica.
     */
    @PutMapping(path = "/formularios/formulario")
    public ResponseEntity<?> atualizarFormulario(@RequestBody FormularioRequestDto formDto, BindingResult result){

        if(result.hasErrors()){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getResultErrors(result));

        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(formularioService.atualizarFormulario(Formulario.fromRequestDto(formDto)));

    }

    /**
     * Pega os erros de validações da requisição e guarda-os em um mapa.
     *
     * @param result - O objeto contendo os erros.
     * @return um mapa com erros de validação da requisição.
     */
    private HashMap<String, String> getResultErrors(BindingResult result){

        HashMap<String, String> erros = new HashMap<>();

        for(FieldError erro : result.getFieldErrors())
            erros.put(erro.getField(), erro.getDefaultMessage());

        return erros;

    }

}
