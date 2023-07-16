package com.br.helpdeskapi.customException.exceptionHandler.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ApiError{

    private static final long serialVersionUID = 1l;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(){}

    public ValidationError(LocalDateTime dataHora, Integer status, String error, String message, String path) {
        super(dataHora, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
