package com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {


    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException (FruitException fruitException){
    FruitErrorResponse fruitErrorResponse = new FruitErrorResponse(fruitException.getMessage(),fruitException.getHttpStatus().value(), LocalDateTime.now());
    log.error("FruitException occured!",fruitErrorResponse.toString());
    return new ResponseEntity<>(fruitErrorResponse,fruitException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException (Exception exception){
        FruitErrorResponse fruitErrorResponse = new FruitErrorResponse(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        log.error("Exception occured!",fruitErrorResponse.toString());
        return new ResponseEntity<>(fruitErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<VegetableErrorResponse> handleException (VegetableException vegetableException){
        VegetableErrorResponse vegetableErrorResponse = new VegetableErrorResponse(vegetableException.getMessage());
        log.error("VegetableException occured!",vegetableErrorResponse.toString());
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












}
