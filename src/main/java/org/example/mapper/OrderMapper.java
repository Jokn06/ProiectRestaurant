package org.example.mapper;

import org.example.entity.Order;
import org.example.model.order.OrderRequest;
import org.example.model.order.OrderResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

//@Mapper(componentModel = "spring")
@ComponentScan
public interface OrderMapper {

    Order map(OrderRequest orderRequest);

    OrderResponse map(Order order);

    List<OrderResponse> map(List<Order> all);


}
