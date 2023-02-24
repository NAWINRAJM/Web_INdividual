package com.example.individual_backend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Appexception extends RuntimeException{
    private final HttpStatus status;
    public Appexception(String message,HttpStatus status){
        super(message);
        this.status=status;
    }
}
