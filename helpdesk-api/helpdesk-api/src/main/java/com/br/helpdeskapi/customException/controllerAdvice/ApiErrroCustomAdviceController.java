package com.br.helpdeskapi.customException.controllerAdvice;

import com.br.helpdeskapi.customException.exceptionHandler.exception.ApiError;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.TecnicoNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiErrroCustomAdviceController {

    @ExceptionHandler(TecnicoNotFoundException.class)
    public ResponseEntity<ApiError> tecnicoNotFounException(TecnicoNotFoundException exception, HttpServletRequest request){

        ApiError apiError =  new ApiError(LocalDateTime.now()
                                          ,HttpStatus.NOT_FOUND.value()
                                          ,"Usuário não encontrado"
                                          , exception.getMessage()
                                          , request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
