package com.java.os.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.os.api.common.TransactionRequest;
import com.java.os.api.common.TransactionResponse;
import com.java.os.api.entity.Order;
import com.java.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) throws JsonProcessingException {
        return service.saveOrder(request);
    }

    @GetMapping("/{orderId}")
    public Order findOrderId(@PathVariable int orderId) throws JsonProcessingException {
        return service.findByOrderId(orderId);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return service.findAllOrders();
    }
}
