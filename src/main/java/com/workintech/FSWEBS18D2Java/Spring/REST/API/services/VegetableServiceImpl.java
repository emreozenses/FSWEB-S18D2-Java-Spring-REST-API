package com.workintech.FSWEBS18D2Java.Spring.REST.API.services;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.dao.VegetableRepository;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Vegetable;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.exceptions.VegetableException;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.validations.VegetableValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private final VegetableRepository vegetableRepository;


    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        VegetableValidation.checkName(vegetable.getName());
        return (Vegetable) vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(Long id) {
        Optional<Vegetable> foundVegetable = vegetableRepository.findById(id);
        if (foundVegetable.isPresent()){
            return foundVegetable.get();
        }
        throw new VegetableException("Vegetable with given id is not exist!", HttpStatus.NOT_FOUND);

    }

    @Override
    public List<Vegetable> orderVegByPriceDesc() {
        return vegetableRepository.orderVegByPriceDesc();
    }

    @Override
    public List<Vegetable> orderVegByPriceAsc() {
        return vegetableRepository.orderVegByPriceAsc();
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetableRepository.findByName(name) ;
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable deletedVegetable = findById(id);
        vegetableRepository.delete(deletedVegetable);
        return deletedVegetable;
    }
}
