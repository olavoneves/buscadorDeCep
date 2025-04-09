package br.com.buscadorDeCep.excecao;

public class InvalidFormatException extends RuntimeException {
    private String messageCepFormat;
    private String messageCepAlfanumeric;
    private String messageCepSpace;

    public InvalidFormatException(String message) {
        this.messageCepFormat = message;
        this.messageCepAlfanumeric = message;
        this.messageCepSpace = message;
    }

    public String getMessageCepFormat() {
        return messageCepFormat;
    }

    public String getMessageCepAlfanumeric() {
        return messageCepAlfanumeric;
    }

    public String getMessageCepSpace() {
        return messageCepSpace;
    }
}
