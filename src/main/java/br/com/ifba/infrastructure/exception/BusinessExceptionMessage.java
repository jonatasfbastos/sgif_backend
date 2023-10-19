package br.com.ifba.infrastructure.exception;

/**
 * @author Giovane Neves
 * Desde V1.0.1
 */
public enum BusinessExceptionMessage {

    // =========================================================== //
    // =============== [        ATRIBUTOS       ] ================ //
    // =========================================================== //

    NOT_FOUND("A instância em questão não existe na base de dados"),
    @Deprecated
    LOGIN_ALREADY_IN_USE("O login já está em uso"),
    ATTRIBUTE_VALUE_ALREADY_EXISTS( "O valor do atributo %s já está em uso");

    private final String mensagem;

    // =========================================================== //
    // =============== [        CONSTRUTOR       ] =============== //
    // =========================================================== //
    BusinessExceptionMessage(String mensagem) {
        this.mensagem = mensagem;
    }

    // =========================================================== //
    // ================ [        METÓDOS       ] ================= //
    // =========================================================== //

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * retorna o valor do enum.
     * @return a mensagem do enum selecionado.
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @author Giovane Neves
     * Desde V1.0.1
     * <p>
     * retorna uma mensagem personalizada para casos em que
     * o valor do atributo já existe na base de dados.
     * @param atributo O atributo o qual o valor já existe e não pode ser cadastrado.
     * @return uma mensagem personalizada.
     */
    public String getMensagemValorJaExiste(String atributo){
        return String.format(mensagem, atributo);
    }
}
