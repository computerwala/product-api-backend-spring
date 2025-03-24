package com.aman.productsapi.service;

import com.aman.productsapi.model.Product;
import com.aman.productsapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository);
    }

    @Test
    void testSearchProducts() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Laptop");
        product.setDescription("Gaming Laptop");

        when(productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase("laptop", "laptop"))
                .thenReturn(Arrays.asList(product));

        List<Product> products = productService.searchProducts("laptop");

        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getTitle());
    }
}