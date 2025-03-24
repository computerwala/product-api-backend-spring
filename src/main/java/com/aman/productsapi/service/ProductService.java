package com.aman.productsapi.service;

import com.aman.productsapi.dto.ProductResponseDTO;
import com.aman.productsapi.model.Product;
import com.aman.productsapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Value("${external.api.url}")
    private String API_URL;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.restTemplate = new RestTemplate();
    }


    public void loadProducts() {
        logger.info("Fetching products from external API: {}", API_URL);
        try {
            ProductResponseDTO response = restTemplate.getForObject(API_URL, ProductResponseDTO.class);

            if (response != null && response.getProducts() != null && !response.getProducts().isEmpty()) {
                productRepository.saveAll(response.getProducts());
                logger.info("Successfully saved {} products to the database", response.getProducts().size());
            } else {
                logger.warn("No products found in external API response.");
            }
        } catch (Exception e) {
            logger.error("Error while fetching products: {}", e.getMessage());
        }
    }


    public List<Product> searchProducts(String query) {
        logger.info(" Searching products with query: {}", query);
        return productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }



    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}