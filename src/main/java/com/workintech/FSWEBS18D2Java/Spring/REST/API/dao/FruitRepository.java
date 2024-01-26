package com.workintech.FSWEBS18D2Java.Spring.REST.API.dao;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Fruit;
import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository {

    @Query(value = "SELECT f.id,f.name,f.price,f.fruit_type FROM fsweb.fruit as f ORDER BY f.price DESC", nativeQuery = true)
    List<Fruit> orderFruitByPriceDesc();

    @Query(value = "SELECT f.id,f.name,f.price,f.fruit_type FROM fsweb.fruit as f ORDER BY f.price ASC",nativeQuery = true)
    List<Fruit> orderFruitByPriceAsc();

    @Query(value = "SELECT f.id,f.name,f.price,f.fruit_type FROM fsweb.fruit as f WHERE f.name ILIKE %:name%",nativeQuery = true)
    List<Fruit> findFruitByName();



}
