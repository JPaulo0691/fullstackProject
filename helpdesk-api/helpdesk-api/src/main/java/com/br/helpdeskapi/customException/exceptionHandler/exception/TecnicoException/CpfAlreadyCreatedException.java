package com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException;

public class CpfAlreadyCreatedException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CpfAlreadyCreatedException(String cpf) {
        super(String.format("O cpf %s já existe em nosso banco de dados", cpf));
    }
}
