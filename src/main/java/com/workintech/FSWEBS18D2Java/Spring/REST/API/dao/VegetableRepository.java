package com.workintech.FSWEBS18D2Java.Spring.REST.API.dao;

import com.workintech.FSWEBS18D2Java.Spring.REST.API.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {

    @Query(value = "SELECT v.id,v.name,v.price,v.is_grown_on_tree FROM fsweb.vegetable as v ORDER BY v.price DESC",nativeQuery = true)
    List<Vegetable> orderVegByPriceDesc();

    @Query(value = "SELECT v.id,v.name,v.price,v.is_grown_on_tree FROM fsweb.vegetable as v ORDER BY v.price ASC",nativeQuery = true)
    List<Vegetable> orderVegByPriceAsc();

    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> findByName(String name);

}
