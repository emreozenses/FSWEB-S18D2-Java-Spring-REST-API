package com.workintech.FSWEBS18D2Java.Spring.REST.API.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="fruit", schema = "fsweb")
public class Fruit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    private FruitType fruitType;


}
