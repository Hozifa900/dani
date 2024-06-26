package com.order_task.order_task.services;

import java.util.List;

import com.order_task.order_task.domain.Order;

public interface OrderService {
    String createOrder(Order order);

    List<Order> getOrders();

    Order getOrder(Long id);

}
