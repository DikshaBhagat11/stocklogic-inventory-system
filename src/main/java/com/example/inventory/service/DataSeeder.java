package com.example.inventory.service;

import com.example.inventory.model.*;
import com.example.inventory.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Arrays;
import jakarta.annotation.Nullable;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(@Nullable String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            // 1. Create Categories
            Category electronics = new Category();
            electronics.setName("Electronics");
            electronics.setDescription("Gadgets and devices");

            Category office = new Category();
            office.setName("Office Supplies");
            office.setDescription("Daily office essentials");

            categoryRepository.saveAll(Arrays.asList(electronics, office));

            // 2. Create Sample Products
            Product laptop = new Product();
            laptop.setName("MacBook Pro");
            laptop.setSku("LAP-001");
            laptop.setPrice(new BigDecimal("1999.99"));
            laptop.setQuantity(15);
            laptop.setMinStockLevel(5);
            laptop.setCategory(electronics);

            Product chair = new Product();
            chair.setName("Ergonomic Chair");
            chair.setSku("FUR-99");
            chair.setPrice(new BigDecimal("299.50"));
            chair.setQuantity(2); // Low stock!
            chair.setMinStockLevel(5);
            chair.setCategory(office);

            productRepository.saveAll(Arrays.asList(laptop, chair));

            System.out.println("✅ Sample data seeded successfully!");
        }
    }
}