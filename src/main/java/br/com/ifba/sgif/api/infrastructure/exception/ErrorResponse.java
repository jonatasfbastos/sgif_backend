package br.com.ifba.sgif.api.infrastructure.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Giovane Neves
 * Desde V1.0.1
 *
 * Classe qye gera mensagens de erros quando uma exeção é disparada
 * no ato de uma requisição HTTP.
 *
 */
@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    /**
     * O código de status da requisição HTTP.
     */
    private final int status;

    /**
     * A mensagem de erro, passada na instância da exceção.
     */
    private final String message;

    /**
     * O rastro da pilha de execução até a origem do erro.
     */
    private String Stacktrace;

    /**
     * Os erros de validação.
     */
    private List<ValidationError> erros;

    /**
     * Classe estática com o campo e a mensagem do erro.
     */
    @Data
    @RequiredArgsConstructor
    public static class ValidationError
    {

        private final String field;
        private final String message;

    }

    /**
     * Adiciona uma nova validação de erro.
     *
     * @param field O campo do erro.
     * @param message A mensagem de erro.
     */
    public void addValidationError(final String field, final String message)
    {

        if(Objects.isNull(erros))
        {
            this.erros = new ArrayList<>();
        }

        this.erros.add(new ValidationError(field, message));
    }


    /**
     * Gera um JSON com mensagem de erro para a requisição HTTP a partir dos dados da instância.
     * @return uma mensagem de erro no formato JSON.
     */
    public String toJson()
    {
        return "{\"Status\": "
                .concat(String.valueOf(this.getStatus()))
                .concat(", ")
                .concat("\"message\": \"")
                .concat(this.getMessage())
                .concat("\"}");
    }


}
