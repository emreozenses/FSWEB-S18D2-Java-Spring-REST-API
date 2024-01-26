package com.workintech.FSWEBS18D2Java.Spring.REST.API.validations;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions.FruitException;
import org.springframework.http.HttpStatus;

public class FruitValidation {

        public static void checkName(String name){
            if(name == null || name.isEmpty()){
                throw new FruitException("name is null or empty!", HttpStatus.BAD_REQUEST);
            }
        }
}
