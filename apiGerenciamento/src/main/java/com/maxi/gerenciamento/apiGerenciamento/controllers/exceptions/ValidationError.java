package com.maxi.gerenciamento.apiGerenciamento.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private static final long serialVersionUID=1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }
    
    public ValidationError(Integer status, Long timestamp, String message, String error, String path) {
        super(status, timestamp, message, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName , String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }


    
}
