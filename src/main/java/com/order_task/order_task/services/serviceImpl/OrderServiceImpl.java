package com.order_task.order_task.services.serviceImpl;

import java.util.List;

import com.order_task.order_task.domain.Order;
import com.order_task.order_task.domain.OrderItem;
import com.order_task.order_task.domain.OrderList;
import com.order_task.order_task.services.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public String createOrder(Order order) {
        try {
            System.out.println("Order created" + order.toString());
            OrderList.addOrder(order);
            float total = 0;
            for (OrderItem e : order.getOrderItems()) {
                total += e.getProduct().getPrice() * e.getQuantity();
            }
            return "Order created with total: " + total;
        } catch (Exception e) {
            return "Error creating order";

        }
    }

    @Override
    public List<Order> getOrders() {
        return OrderList.getOrders();

    }

    @Override
    public Order getOrder(Long id) {
        for (Order e : OrderList.getOrders()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
