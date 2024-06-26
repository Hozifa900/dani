package com.order_task.order_task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;

}
