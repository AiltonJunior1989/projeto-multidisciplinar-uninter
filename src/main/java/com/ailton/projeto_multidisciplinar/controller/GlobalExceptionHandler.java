package com.ailton.projeto_multidisciplinar.controller;

import com.ailton.projeto_multidisciplinar.infrastructure.exceptions.Conflict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
}
