package com.workintech.FSWEBS18D2Java.Spring.REST.API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "vegetable",schema = "fsweb")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    private Long id;

    @Column(name = "name")
    @NotBlank
    @NotNull
    @Size( min = 3 , max = 50)
    private String name;

    @Column(name = "price")
    @NotNull
    @NotBlank
    private Double price;

    @Column(name = "is_grown_on_tree")
    @NotNull
    @NotBlank
    private boolean isGrownOnTree;

}
