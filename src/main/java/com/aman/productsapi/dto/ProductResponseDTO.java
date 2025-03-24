package com.aman.productsapi.dto;

import com.aman.productsapi.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDTO {
    private List<Product> products;


}
