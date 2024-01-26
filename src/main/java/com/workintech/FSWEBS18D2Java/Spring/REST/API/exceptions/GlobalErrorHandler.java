package com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {


    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException (FruitException fruitException){
    FruitErrorResponse fruitErrorResponse = new FruitErrorResponse(fruitException.getMessage());
    log.error("FruitException occured!",fruitException.getMessage());
    return new ResponseEntity<>(fruitErrorResponse,fruitException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<VegetableErrorResponse> handleException (VegetableException vegetableException){
        VegetableErrorResponse vegetableErrorResponse = new VegetableErrorResponse(vegetableException.getMessage());
        log.error("VegetableException occured!",vegetableException.getMessage());
        return new ResponseEntity<>(vegetableErrorResponse,vegetableException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError ->{
                    Map<String,String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());
        log.error("MethodArgumentNotValidException occured!",exception.getMessage());
        return new ResponseEntity(errorList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<VegetableErrorResponse> handleException (Exception exception){
        VegetableErrorResponse errorResponse = new VegetableErrorResponse(exception.getMessage());
        log.error("Exception occured!",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }










}
