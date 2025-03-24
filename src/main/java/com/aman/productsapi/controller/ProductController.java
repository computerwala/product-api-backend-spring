package com.aman.productsapi.controller;

import com.aman.productsapi.model.Product;
import com.aman.productsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/load")
    public ResponseEntity<String> loadProducts(){
        productService.loadProducts();
        return ResponseEntity.ok("Product loaded Successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){

        return ResponseEntity.ok(productService.searchProducts(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return (product != null) ? ResponseEntity.ok(product) : ResponseEntity
                                                                    .notFound()
                                                                    .build();
    }


}
