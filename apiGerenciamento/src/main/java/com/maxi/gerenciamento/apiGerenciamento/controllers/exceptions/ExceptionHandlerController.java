package com.maxi.gerenciamento.apiGerenciamento.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.DataIntegrityViolationException;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage(), "Objecto não encontrado", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage(), "Violação de dados", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError errors = new ValidationError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), "Campo ou atributo não pode ser nulo", "Erro na validação de entrada", request.getRequestURI());
        for(FieldError err : e.getBindingResult().getFieldErrors()){
            errors.addError(err.getField(), err.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage(), "Violação de dados", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), "O id deve ser um número inteiro.", "Violação de dados", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.METHOD_NOT_ALLOWED.value(), System.currentTimeMillis(), "O endereço que intenta aceder não está habilitado.", "URL incorreta", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(error);
    }

    //HttpRequestMethodNotSupportedException
}
