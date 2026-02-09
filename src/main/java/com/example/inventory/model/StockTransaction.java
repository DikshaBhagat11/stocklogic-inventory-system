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
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "change_amount")
    private Integer changeAmount;

    @Column(name = "transaction_type")
    private String transactionType;

    private String reason;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}