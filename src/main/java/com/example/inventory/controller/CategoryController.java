package com.example.inventory.controller;

import com.example.inventory.model.Category;
import com.example.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final InventoryService inventoryService;

    public CategoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return inventoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return inventoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        inventoryService.deleteCategory(id);
    }
}