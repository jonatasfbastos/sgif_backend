package br.com.ifba.infrastructure.exception;

public enum BusinessExceptionMessage {

    NOT_FOUND("A instância em questão não existe na base de dados"),

    LOGIN_ALREADY_IN_USE("O login já está em uso");


    private final String mensagem;

    BusinessExceptionMessage(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
