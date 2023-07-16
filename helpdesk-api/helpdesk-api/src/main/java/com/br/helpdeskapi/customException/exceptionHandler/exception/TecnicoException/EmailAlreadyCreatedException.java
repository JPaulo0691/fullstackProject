package com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException;

public class EmailAlreadyCreatedException extends RuntimeException{

    public EmailAlreadyCreatedException(String email) {
        super(String.format("Este email: %s, já está cadastrado em nosso sistema, insira outro.", email));
    }
}
