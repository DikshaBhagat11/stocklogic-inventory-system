package com.example.inventory.controller;

import com.example.inventory.model.Product;
import com.example.inventory.model.StockTransaction;
import com.example.inventory.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final InventoryService inventoryService;

    public ProductController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return inventoryService.getAllProducts();
    }

    // New endpoint for alerts!
    @GetMapping("/low-stock")
    public List<Product> getLowStock() {
        return inventoryService.getLowStockProducts();
    }

    // New POST endpoint to update stock
    @PostMapping("/{id}/stock")
    public Product updateStock(
            @PathVariable Long id,
            @RequestParam int amount,
            @RequestParam String type,
            @RequestParam String reason) {
        return inventoryService.updateStock(id, amount, type, reason);
    }

    @GetMapping("/transactions")
    public List<StockTransaction> getTransactionHistory() {
        return inventoryService.getTransactionHistory();
    }
}