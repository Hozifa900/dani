package com.order_task.order_task.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order_task.order_task.domain.Order;
import com.order_task.order_task.services.OrderService;
import com.order_task.order_task.services.serviceImpl.OrderServiceImpl;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    OrderService orderService = new OrderServiceImpl();

    @PostMapping("")
    public String createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

}
