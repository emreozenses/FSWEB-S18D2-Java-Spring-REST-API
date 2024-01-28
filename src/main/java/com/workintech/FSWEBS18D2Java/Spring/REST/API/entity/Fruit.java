package com.workintech.FSWEBS18D2Java.Spring.REST.API.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Positive
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3,max = 50,message = "3 den küçük , 50 den büyük karakter içeremez!")
    private String name;

    @Column(name = "price")
    @NotNull
    @DecimalMin("10")
    private Double price;

    @Enumerated(EnumType.STRING)
    @NotNull
    private FruitType fruitType;


}
