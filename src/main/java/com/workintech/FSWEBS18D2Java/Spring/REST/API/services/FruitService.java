package com.workintech.FSWEBS18D2Java.Spring.REST.API.services;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Fruit;

import java.util.List;

public interface FruitService {


    Fruit save (Fruit fruit);

    List<Fruit> findAll ();

    Fruit findById(Long id);

    List<Fruit> findFruitByName(String name);
    List<Fruit> orderFruitByPriceDesc();

    List<Fruit> orderFruitByPriceAsc();

    Fruit delete (Long id);



}
