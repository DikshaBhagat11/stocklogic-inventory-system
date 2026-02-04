package com.example.inventory.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    // This bridges the gap: Java says 'password', SQL says 'password_hash'
    @Column(name = "password_hash", nullable = false)
    private String password; // We will hash this later

    private String role; // e.g., "ADMIN", "USER"
}