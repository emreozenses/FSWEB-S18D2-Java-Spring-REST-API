package com.workintech.FSWEBS18D2Java.Spring.REST.API.dto;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Fruit;

public record FruitResponse(String message, Fruit fruit) {
}
