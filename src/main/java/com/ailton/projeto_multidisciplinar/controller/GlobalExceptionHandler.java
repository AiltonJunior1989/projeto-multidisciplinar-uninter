package com.ailton.projeto_multidisciplinar.controller;

import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.Conflict;
import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

//@ControllerAdvice - Permite o tratamento global de exceções
@ControllerAdvice
public class GlobalExceptionHandler {
    //aqui está sendo usado o status code de confli criado em exceptions
    @ExceptionHandler(Conflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleUnprocessableEntity(Conflict e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    //Esste método irá responder com uma mensagem caso tenha um erro interno no servidor
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleUnprocessableEntity(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
    }

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleUnprocessableEntity(NotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: " + e.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.UnprocessableContent.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    public ResponseEntity<String> handleUnprocessableEntity(UnsupportedClassVersionError e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body("Erro: " + e.getMessage());
    }
}
