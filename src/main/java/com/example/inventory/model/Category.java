package com.example.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    // This shows the "One-to-Many" relationship: One category has many products
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
}