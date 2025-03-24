package com.aman.productsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @NotNull
    private Long id;

    @NotBlank
    private String title;
    @NotBlank
    private String description;

    @Positive
    private Double price;

    private String category;
    private String brand;
    private String thumbnail;
}


