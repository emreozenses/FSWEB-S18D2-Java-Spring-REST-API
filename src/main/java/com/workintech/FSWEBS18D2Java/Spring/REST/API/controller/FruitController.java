package com.workintech.FSWEBS18D2Java.Spring.REST.API.controller;


import com.workintech.FSWEBS18D2Java.Spring.REST.API.dto.FruitResponse;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Fruit;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.services.FruitService;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.services.FruitServiceImpl;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/workintech")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

@GetMapping("/fruits")
    public List<Fruit> findAll(){
        return fruitService.orderFruitByPriceAsc();
}

@GetMapping("/fruits/desc")
    public List<Fruit> findAllDsc(){
        return fruitService.orderFruitByPriceDesc();
}

@GetMapping("/fruits/{id}")
    public FruitResponse findById(@Positive @PathVariable Long id){

        return new FruitResponse("succeed",fruitService.findById(id)) ;
}

@PostMapping("/fruits/{name}")
public List<Fruit> findByName(@Size(min = 3,max = 50) @PathVariable String name){
        return fruitService.findFruitByName(name);
}

@PostMapping("/fruits")
@ResponseStatus(HttpStatus.CREATED)
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
}

@DeleteMapping("/fruits/{id}")
    public Fruit delete(@Positive @PathVariable Long id){
        return fruitService.delete(id);
}

}
