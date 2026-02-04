package com.example.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private Integer minStockLevel;

    // This maps the "category_id" foreign key you created in SQL
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}