package com.example.demoagent.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class OrderMcpServerService {

    @Tool(description = "Get the status of an order by its ID.")
    public String getOrderStatus(@ToolParam(description = "orderid") String orderid) {
        // Simulate fetching order status from a server

        return switch (orderid.toLowerCase()){
            case "123" -> "Order 123: Shipped";
            case "456" -> "Order 456: In Transit";
            case "789" -> "Order 789: Delivered";
            default -> "Order not found";
        };
    }
    @Tool(description = "Get the description of an order by its ID.")
    public String getOrderDescriptionById(@ToolParam(description = "orderid") String orderid) {
        // Simulate fetching order description from a server

        return switch (orderid.toLowerCase()){
            case "123" -> "big order";
            case "456" -> "medium order";
            case "789" -> "small order";
            default -> "Order not found";
        };
    }

    @Tool(description = "Insert an order into the database.")
    public String insertOrder(@ToolParam(description = "orderid") String orderid, @ToolParam(description = "orderdescription") String orderdescription) {
        // Simulate inserting order into a database
        return "Order inserted: " + orderid + " " + orderdescription;
    }
}
