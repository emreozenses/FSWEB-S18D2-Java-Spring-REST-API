package com.workintech.FSWEBS18D2Java.Spring.REST.API.controller;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.dto.VegetableResponse;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Fruit;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Vegetable;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/workintech")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }


    @GetMapping("/vegetables")
    public List<Vegetable> findAll(){
        return vegetableService.orderVegByPriceAsc();
    }

    @GetMapping("/vegetables/desc")
    public List<Vegetable> findAllDsc(){
        return vegetableService.orderVegByPriceDesc();
    }

    @GetMapping("/vegetables/{id}")
    public VegetableResponse findById(@PathVariable Long id){

        return new VegetableResponse(vegetableService.findById(id).getName(),vegetableService.findById(id).getPrice()) ;
    }

    @PostMapping("/vegetables/{name}")
    public List<Vegetable> findByName(@PathVariable String name){
        return vegetableService.findByName(name);
    }

    @PostMapping("/vegetables")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/vegetables/{id}")
    public Vegetable delete(@PathVariable Long id){
        return vegetableService.delete(id);
    }




}
