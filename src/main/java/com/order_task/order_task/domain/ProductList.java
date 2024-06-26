package com.order_task.order_task.domain;

import java.util.*;

public class ProductList {
    private static List<Product> products = new ArrayList<>();

    public static List<Product> getProducts() {
        products.add(new Product(1L, "apples", 0.60));
        products.add(new Product(2L, "oranges", 0.25));
        return products;
    }

}
