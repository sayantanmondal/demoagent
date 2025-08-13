package com.example.demoagent.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class OrderMcpServerService {

    private final InMemoryOrderRepository repository;

    public OrderMcpServerService(InMemoryOrderRepository repository) {
        this.repository = repository;
    }

    @Tool(description = "Get the status of an order by its ID.")
    public String getOrderStatus(@ToolParam(description = "orderid") String orderid) {
        return repository.findById(orderid)
                .map(order -> "Order " + order.getId() + ": " + order.getStatus())
                .orElse("Order not found");
    }

    @Tool(description = "Get the description of an order by its ID.")
    public String getOrderDescriptionById(@ToolParam(description = "orderid") String orderid) {
        return repository.findById(orderid)
                .map(InMemoryOrderRepository.Order::getDescription)
                .orElse("Order not found");
    }

    @Tool(description = "Insert an order into the database.")
    public String insertOrder(@ToolParam(description = "orderid") String orderid, @ToolParam(description = "orderdescription") String orderdescription) {
        repository.save(orderid, orderdescription, "New");
        return "Order inserted: " + orderid + " " + orderdescription;
    }
}
