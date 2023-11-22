package br.com.ifba.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.exception.ExceptionUtils;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
            final MethodArgumentNotValidException methodArgumentNotValidException,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {

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
            final Exception exception,
            final WebRequest request) {

        final String mensagemErro = "Ocorreu um erro inesperado";

        log.error(mensagemErro, exception);

        return construirMensagemDeErro(
                exception,
                mensagemErro,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }


    /**
     *
     * Trata a exceção 'BusinessException'.
     *
     * @param businessException - A instância de 'BusinessException'.
     * @param request - A requisição HTTP.
     * @return uma entidade generica com a mensagem de erro.
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBusinessException(
            final BusinessException businessException,
            final WebRequest request) {

        final String mensagemErro = businessException.getMessage();

        log.error(mensagemErro, businessException);

        return construirMensagemDeErro(
                businessException,
                mensagemErro,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }

    /**
     *
     * Trata a exceção 'UsernameNotFoundException'.
     *
     * @param exception - A instância de 'UsernameNotFoundException'.
     * @param request - A requisição HTTP.
     * @return uma entidade generica com a mensagem de erro.
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleUsernameNotFoundException(
            final UsernameNotFoundException exception,
            final WebRequest request) {

        final String mensagemErro = exception.getMessage();

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
            final Exception exception,
            final String message,
            final HttpStatus httpStatus,
            final WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
        if (this.printStackTrace) {
            errorResponse.setStacktrace(ExceptionUtils.getStackTrace(exception));
        }

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

}
