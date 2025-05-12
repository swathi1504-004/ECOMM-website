package test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import dao.OrderProcessorRepositoryImpl;
import entity.Customer;
import entity.Product;
import exception.CustomerNotFoundException;
import exception.ProductNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EcomAppTest {
    private OrderProcessorRepositoryImpl orderProcessor;

    @BeforeEach
    void setUp() {
        // Initialize your repository with necessary setup
        orderProcessor = new OrderProcessorRepositoryImpl();
    }

    @Test
    void testProductCreation() {
        // Create a product
        Product product = new Product(9, "Dryer", 100.0, "hair dryer", 2);
        boolean result = orderProcessor.createProduct(product);
        assertTrue(result, "Product should be created successfully");
    }

    @Test
    void testAddToCart() throws CustomerNotFoundException, ProductNotFoundException {
        // Assuming you have a Customer object and a Product object
        Customer customer = new Customer(1, "John Doe", "john@example.com", "password123");
        Product product = new Product(1, "Dryer", 100.0, "hair dryer", 2);
        boolean result = orderProcessor.addToCart(customer, product, 1);
        assertTrue(result, "Product should be added to cart successfully");
    }

    @Test
    void testOrderPlacement() {
        // Implement a test to check if an order is placed successfully
        Customer customer = new Customer(1, "John Doe", "john@example.com", "password123");
        Product product = new Product(1, "Dryer", 100.0, "hair dryer", 2);
        List<Map<Product, Integer>> productsWithQuantity = new ArrayList<>();
        // Add products to the list
        Map<Product, Integer> productQuantityMap = new HashMap<>();
        productQuantityMap.put(product, 1);
        productsWithQuantity.add(productQuantityMap);

        boolean result = orderProcessor.placeOrder(customer, productsWithQuantity, "123 Main St");
        assertTrue(result, "Order should be placed successfully");
    }

    @Test
    void testProductNotFoundException() {
        // Test that the correct exception is thrown when a product is not found
        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
            ( orderProcessor).getProductById(999); // Assuming 999 is an invalid ID
        });
        assertEquals("Product not found", exception.getMessage());
    }

    // Add more test cases as needed...
}
