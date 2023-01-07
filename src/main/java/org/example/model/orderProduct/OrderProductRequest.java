package org.example.model.orderProduct;

import lombok.Data;
import org.example.entity.Order;
import org.example.entity.Product;

import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

@Data
public class OrderProductRequest {

    private Integer id;

    @FutureOrPresent
    private LocalDateTime dateStart;

    @FutureOrPresent
    private LocalDateTime delivered;

    @FutureOrPresent
    private LocalDateTime canceled;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}
