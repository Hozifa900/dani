package com.order_task.order_task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.order_task.order_task.domain.Order;
import com.order_task.order_task.domain.OrderItem;
import com.order_task.order_task.domain.OrderList;
import com.order_task.order_task.domain.Product;
import com.order_task.order_task.services.serviceImpl.OrderServiceImpl;

public class OrderOfferTest {
    @Mock
    private OrderItem orderItemMock;

    @Mock
    private OrderList orderListMock;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOrder_NoOffers() {
        // Prepare test data
        List<OrderItem> orderItems = new ArrayList<>();
        Product apple = new Product(1L, "Apple", 0.60f); // Assuming product ID 1 is Apple
        orderItems.add(new OrderItem(apple.getId(), 2)); // 2 apples

        Order order = new Order();
        order.setOrderItems(orderItems);

        // Mock behavior
        when(orderItemMock.getProduct()).thenReturn(apple);
        when(orderItemMock.getQuantity()).thenReturn(2);
        // when(orderListMock.addOrder(order)).thenReturn(true);

        // Call method under test
        String result = orderService.createOrder(order);

        // Assert results
        assertEquals("Order created with total: 1.2", result); // Total should be 2 * 0.60
        assertEquals("Order created", order.getStatus()); // Status should be updated
    }

    @Test
    public void testCreateOrder_WithOffers() {
        // Prepare test data
        List<OrderItem> orderItems = new ArrayList<>();
        Product orange = new Product(2L, "Orange", 0.25f); // Assuming product ID 2 is Orange
        orderItems.add(new OrderItem(orange.getId(), 6)); // 6 oranges

        Order order = new Order();
        order.setOrderItems(orderItems);

        // Mock behavior
        when(orderItemMock.getProduct()).thenReturn(orange);
        when(orderItemMock.getQuantity()).thenReturn(6);
        // when(orderListMock.addOrder(order)).thenReturn(true);

        // Call method under test
        String result = orderService.createOrder(order);

        // Assert results
        assertEquals("Order created with total: 1.0", result); // Total should be (6 * 0.25) - (6 / 3 * 0.25)
        assertEquals("Order created", order.getStatus()); // Status should be updated
    }

    @Test
    public void testCreateOrder_Error() {
        // Prepare test data with a null order
        Order order = null;

        // Call method under test
        String result = orderService.createOrder(order);

        // Assert results
        assertEquals("Error creating order", result); // Should return error message
    }

}
