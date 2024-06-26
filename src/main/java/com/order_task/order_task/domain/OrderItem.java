package com.order_task.order_task.domain;

import lombok.Data;

@Data
public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Long productId, int quantity) {
        Product product = ProductList.getProducts().stream().filter(p -> p.getId().equals(productId)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        this.product = product;
        this.quantity = quantity;
    }

}
