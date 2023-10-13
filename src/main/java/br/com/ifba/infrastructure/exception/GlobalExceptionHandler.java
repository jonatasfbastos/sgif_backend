package br.com.ifba.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.exception.ExceptionUtils;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Giovane Neves
 * Desde v1.0.1
 *
 * Tratamento global de exceções, retorna respostas json de erro para a requisição HTTP
 * quando uma exceção é disparada.
 */
@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //
    
    /**
     * Valor que determina se a 'stackTrace' deve ser mostrada no client.
     */
    @Value(value = "${server.error.include-exception}")
    private boolean printStackTrace;


    // =========================================================== //
    // =============== [        MÉTODOS       ] ================== //
    // =========================================================== //

    /**
     *
     * Trata exceções genericas
     *
     * @param methodArgumentNotValidException - O argumento inválido.
     * @param headers - Os cabeçalhos da requisição HTTP.
     * @param status - O código de status da requisição HTTP.
     * @param request - A requisição HTTP.
     * @return uma entidade generica com a mensagem de erro.
     */
    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException methodArgumentNotValidException,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de validação. Veja o campo de 'erros' para saber mais detalhes.");

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.unprocessableEntity().body(errorResponse);

    }

    /**
     *
     * Trata a exceção 'Exception'.
     *
     * @param exception - A instância de 'Exception'.
     * @param request - A requisição HTTP.
     * @return uma entidade generica com a mensagem de erro.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(
            Exception exception,
            WebRequest request) {

        final String mensagemErro = "Ocorreu um erro inesperado";

        log.error(mensagemErro, exception);

        return construirMensagemDeErro(
                exception,
                mensagemErro,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }


    /**
     * Constroi uma mensagem de erro.
     *
     * @param exception  A exceção.
     * @param message    A mensagem de exceção.
     * @param httpStatus O status da requisição.
     * @param request    A requisição.
     * @return a mensagem de erro.
     */
    private ResponseEntity<Object> construirMensagemDeErro(
            Exception exception,
            String message,
            HttpStatus httpStatus,
            WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
        if (this.printStackTrace) {
            errorResponse.setStacktrace(ExceptionUtils.getStackTrace(exception));
        }

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

}
