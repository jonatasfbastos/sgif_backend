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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
     * @apiNote Endpoint criado desde a versão 1.0.0
     *
     * @return uma entidade de resposta generica.
     */
    @PostMapping(path = "/formularios/formulario")
    public ResponseEntity<?> salvarFormulario(@RequestBody FormularioRequestDto formDto, BindingResult result){


        if(result.hasErrors()){

            HashMap<String, String> erros = new HashMap<>();

            for(FieldError erro : result.getFieldErrors())
                erros.put(erro.getField(), erro.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);

        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(formularioService.salvarFormulario(Formulario.fromRequestDto(formDto)));
    }

}
