package com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FruitException extends RuntimeException{

    public HttpStatus httpStatus;

    public FruitException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
