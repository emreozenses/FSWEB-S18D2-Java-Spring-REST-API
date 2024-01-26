package com.workintech.FSWEBS18D2Java.Spring.REST.API.validations;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions.VegetableException;
import org.springframework.http.HttpStatus;

public class VegetableValidation {

    public static void checkName (String name){
        if(name == null || name.isEmpty()){
            throw new VegetableException("name is null or empty!", HttpStatus.BAD_REQUEST);
        }
    }
}
