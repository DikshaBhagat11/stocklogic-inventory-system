package com.example.inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_transactions")
@Data
public class StockTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer changeAmount; // Positive for additions, negative for sales

    private String transactionType; // e.g., "PURCHASE", "SALE"

    private LocalDateTime createdAt = LocalDateTime.now();
}