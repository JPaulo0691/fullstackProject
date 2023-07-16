package com.br.helpdeskapi.customException.exceptionHandler.exception.ClienteException;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Integer id) {
        super(String.format("O cliente de id.%d, não foi encontrado", id));
    }
}
