package com.workintech.FSWEBS18D2Java.Spring.REST.API.controller;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Fruit;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable save (Vegetable vegetable);

    List<Vegetable> findAll ();

    Vegetable findById(Long id);

    List<Vegetable> orderVegByPriceDesc();
    List<Vegetable> orderVegByPriceAsc();

    List<Vegetable> findByName(String name);

    Vegetable delete (Long id);


}
