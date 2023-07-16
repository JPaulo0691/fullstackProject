package com.br.helpdeskapi.customException.controllerAdvice.Cliente;

import com.br.helpdeskapi.customException.exceptionHandler.exception.ApiError;
import com.br.helpdeskapi.customException.exceptionHandler.exception.ClienteException.ClientNotFoundException;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.TecnicoComChamadoAtivoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ClienteNotFoundControllerAdvice {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiError> emailAlreadyCreated(ClientNotFoundException exception, HttpServletRequest request){

        ApiError apiError =  new ApiError(LocalDateTime.now()
                , HttpStatus.BAD_REQUEST.value()
                ,"Cliente Não Encontrado"
                , exception.getMessage()
                , request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
