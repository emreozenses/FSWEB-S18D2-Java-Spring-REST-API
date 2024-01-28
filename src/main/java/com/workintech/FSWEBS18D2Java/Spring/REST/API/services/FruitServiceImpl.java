package com.workintech.FSWEBS18D2Java.Spring.REST.API.services;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.dao.FruitRepository;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Fruit;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions.FruitException;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.validations.FruitValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
      //  FruitValidation.checkName(fruit.getName());
        return (Fruit) fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit findById(Long id) {
        Optional<Fruit> foundFruit = fruitRepository.findById(id);
        if (foundFruit.isPresent()){
            return foundFruit.get();
        }
        throw new FruitException("Fruit with given id is not exist!", HttpStatus.NOT_FOUND);

    }

    @Override
    public List<Fruit> findFruitByName(String name) {
        return fruitRepository.findFruitByName(name);
    }

    @Override
    public List<Fruit> orderFruitByPriceDesc() {
        return fruitRepository.orderFruitByPriceDesc();
    }

    @Override
    public List<Fruit> orderFruitByPriceAsc() {
        return fruitRepository.orderFruitByPriceAsc();
    }

    @Override
    public Fruit delete(Long id) {
        Fruit deletedFruit = findById(id);
        fruitRepository.delete(deletedFruit);
        return deletedFruit;
    }
}
