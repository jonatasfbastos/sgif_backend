package br.com.ifba.infrastructure.exception;

public enum BusinessExceptionMessage {

    NOT_FOUND("A instância em questão não existe na base de dados");

    private final String mensagem;

    BusinessExceptionMessage(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
