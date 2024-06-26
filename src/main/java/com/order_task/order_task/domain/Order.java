package com.order_task.order_task.domain;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@NoArgsConstructor
public class Order {
    private Long id;
    private List<OrderItem> orderItems = new ArrayList<>();
    private double total;
    private String status;

}
