package com.br.helpdeskapi.customException.controllerAdvice.Tecnico;

import com.br.helpdeskapi.customException.exceptionHandler.exception.ApiError;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.CpfAlreadyCreatedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CpfAlreadyCreatedCustomControllerAdvice {

    @ExceptionHandler(CpfAlreadyCreatedException.class)
    public ResponseEntity<ApiError> cpfAlreadyCreated(CpfAlreadyCreatedException exception, HttpServletRequest request){

        ApiError apiError =  new ApiError(LocalDateTime.now()
                                        , HttpStatus.BAD_REQUEST.value()
                                        ,"Cpf já cadastrado"
                                        , exception.getMessage()
                                        , request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
