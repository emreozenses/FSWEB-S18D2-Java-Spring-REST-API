package com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FruitErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime dateTime;

}
