package com.example.inventory.service;

import com.example.inventory.model.Product;
import com.example.inventory.model.StockTransaction;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.StockTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import this!
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class InventoryService {

    private final ProductRepository productRepository;
    private final StockTransactionRepository transactionRepository;

    // Update constructor to include the new repository
    public InventoryService(ProductRepository productRepository, StockTransactionRepository transactionRepository) {
        this.productRepository = productRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getLowStockProducts() {
        return productRepository.findAll().stream()
                .filter(p -> p.getQuantity() < p.getMinStockLevel())
                .toList();
    }

    @Transactional
    public Product updateStock(Long productId, int amount, String type, String reason) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 1. Update the Product's current quantity
        product.setQuantity(product.getQuantity() + amount);
        productRepository.save(product);

        // 2. Create the Transaction record using your specific names
        StockTransaction transaction = new StockTransaction();
        transaction.setProduct(product);
        transaction.setChangeAmount(amount);      // Matches 'change_amount'
        transaction.setTransactionType(type);     // Matches 'transaction_type'
        transaction.setReason(reason);
        transaction.setCreatedAt(LocalDateTime.now()); // Matches 'created_at'

        transactionRepository.save(transaction);

        return product;
    }

    public List<StockTransaction> getTransactionHistory() {
        return transactionRepository.findAll();
    }

    public Product createProduct(Product product) {
        // If no category is set, you'd handle that here,
        // but for now, we'll assume the frontend sends a valid Category ID.
        return productRepository.save(product);
    }

    public Map<String, Object> getInventoryStats() {
        List<Product> products = productRepository.findAll();

        long totalItems = products.size();
        long lowStockCount = products.stream()
                .filter(p -> p.getQuantity() < p.getMinStockLevel())
                .count();
        double totalValue = products.stream()
                .mapToDouble(p -> p.getPrice()
                        .multiply(java.math.BigDecimal.valueOf(p.getQuantity()))
                        .doubleValue())
                .sum();

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalItems", totalItems);
        stats.put("lowStockCount", lowStockCount);
        stats.put("totalValue", totalValue);

        return stats;
    }
}