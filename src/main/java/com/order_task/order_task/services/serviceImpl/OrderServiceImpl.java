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

            int appleOffer = 0;
            int orangeOffer = 0;

            float total = 0;

            for (OrderItem e : order.getOrderItems()) {
                total += e.getProduct().getPrice() * e.getQuantity();
                // the coming conditions for offer calculation
                if (e.getProduct().getId() == 1) {
                    appleOffer = e.getQuantity() / 1;
                }
                if (e.getProduct().getId() == 2) {
                    orangeOffer = e.getQuantity() / 3;
                }

            }

            System.out.println("Total: " + total);
            // calculate the total price after the offer of oranges
            total = total - orangeOffer * 0.25f;

            // add the total price to the order
            order.setTotal(total);

            // add the offer of apples to the order
            for (OrderItem o : order.getOrderItems()) {
                if (o.getProduct().getId() == 1) {
                    o.setQuantity(o.getQuantity() + appleOffer);
                }

            }

            // update the order status to created
            order.setStatus("Order created");
            OrderList.addOrder(order);
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
