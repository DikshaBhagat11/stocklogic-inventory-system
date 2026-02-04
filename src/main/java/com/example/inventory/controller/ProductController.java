package com.example.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Tells Spring this class handles web requests
public class ProductController {

    @GetMapping("/") // This handles the main page (http://localhost:8080/)
    public String welcomeMessage() {
        return "The Inventory API is officially running!";
    }
}