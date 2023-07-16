package com.br.helpdeskapi.customException.controllerAdvice.Tecnico;

import com.br.helpdeskapi.customException.exceptionHandler.exception.ApiError;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.EmailAlreadyCreatedException;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.TecnicoComChamadoAtivoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TecnicoComChamadoControllerAdvice {

    @ExceptionHandler(TecnicoComChamadoAtivoException.class)
    public ResponseEntity<ApiError> emailAlreadyCreated(TecnicoComChamadoAtivoException exception, HttpServletRequest request){

        ApiError apiError =  new ApiError(LocalDateTime.now()
                , HttpStatus.BAD_REQUEST.value()
                ,"Técnico com chamado ativo"
                , exception.getMessage()
                , request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
