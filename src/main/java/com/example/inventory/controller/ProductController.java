package com.example.inventory.controller;

import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    // Dependency Injection: IntelliJ will automatically provide the repository
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // This handles GET requests to http://localhost:8080/api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}