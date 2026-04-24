package com.ailton.projeto_multidisciplinar.infrastructure.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Deve-se criar nas exceções o tipo de status code que quer ser usado no projeto e referenciar ele em
//GlobalExceptionHanler
@ResponseStatus(HttpStatus.CONFLICT)
public class Conflict extends RuntimeException {
    public Conflict(String message) {
        super(message);
    }
}

