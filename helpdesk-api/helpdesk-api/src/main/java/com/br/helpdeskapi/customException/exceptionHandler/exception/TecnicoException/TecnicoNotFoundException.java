package com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException;

public class TecnicoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TecnicoNotFoundException(Integer id){
        super(String.format("O usuário que vc buscou de id.%d, não existe.", id));
    }
}
