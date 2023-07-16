package com.br.helpdeskapi.customException.controllerAdvice;

import com.br.helpdeskapi.customException.exceptionHandler.exception.ApiError;
import com.br.helpdeskapi.customException.exceptionHandler.exception.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ValidationErrorAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> emailAlreadyCreated(MethodArgumentNotValidException exception, HttpServletRequest request){

        ValidationError apiError =  new ValidationError(LocalDateTime.now()
                , HttpStatus.BAD_REQUEST.value()
                ,"Validation Error."
                , "Erro na validação dos campos"
                , request.getRequestURI());

        for(FieldError error: exception.getBindingResult().getFieldErrors()){
            apiError.addErrors(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
