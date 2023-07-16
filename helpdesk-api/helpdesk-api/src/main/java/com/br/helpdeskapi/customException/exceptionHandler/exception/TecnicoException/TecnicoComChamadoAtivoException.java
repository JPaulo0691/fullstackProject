package com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException;

public class TecnicoComChamadoAtivoException extends RuntimeException{

    public TecnicoComChamadoAtivoException(Integer id){
        super(String.format("O Técnico de id.%d possui chamado ativo e não pode ser deletado", id));
    }
}
