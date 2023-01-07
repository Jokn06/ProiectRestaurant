package org.example.model.orderProduct;

import lombok.Data;
import org.example.entity.Order;
import org.example.entity.Product;

import java.time.LocalDateTime;

@Data
public class OrderProductResponse {

    private Integer id;
    private LocalDateTime dateStart;
    private LocalDateTime delivered;
    private LocalDateTime canceled;
    private Order order;
    private Product product;
}