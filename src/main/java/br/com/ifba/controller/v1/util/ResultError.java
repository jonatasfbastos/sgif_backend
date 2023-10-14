package br.com.ifba.controller.v1.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 *
 */
public class ResultError {


    /**
     * Pega os erros de validações da requisição e guarda-os em um mapa.
     *
     * @param result - O objeto contendo os erros.
     * @return um mapa com erros de validação da requisição.
     */
    public static HashMap<String, String> getResultErrors(BindingResult result){

        HashMap<String, String> erros = new HashMap<>();

        for(FieldError erro : result.getFieldErrors())
            erros.put(erro.getField(), erro.getDefaultMessage());

        return erros;

    }
}
