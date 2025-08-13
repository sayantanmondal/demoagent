package com.example.demoagent.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryOrderRepository {

    public static class Order {
        private final String id;
        private final String description;
        private final String status;

        public Order(String id, String description, String status) {
            this.id = id;
            this.description = description;
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getStatus() {
            return status;
        }
    }

    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    @PostConstruct
    public void initializeSampleData() {
        // Initialize with 10 sample orders
        orders.put("100", new Order("100", "big order", "Shipped"));
        orders.put("101", new Order("101", "medium order", "In Transit"));
        orders.put("102", new Order("102", "small order", "Delivered"));
        orders.put("103", new Order("103", "bulk order", "Processing"));
        orders.put("104", new Order("104", "express order", "Shipped"));
        orders.put("105", new Order("105", "international order", "Customs"));
        orders.put("106", new Order("106", "gift order", "Packed"));
        orders.put("107", new Order("107", "return order", "Received"));
        orders.put("108", new Order("108", "subscription order", "Pending"));
        orders.put("109", new Order("109", "replacement order", "In Transit"));
    }

    public Optional<Order> findById(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(orders.get(id));
    }

    public void save(String id, String description, String status) {
        if (id == null) {
            return;
        }
        orders.put(id, new Order(id, description, status));
    }
} 