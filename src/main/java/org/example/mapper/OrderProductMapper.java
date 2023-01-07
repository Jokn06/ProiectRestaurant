package org.example.mapper;

import org.example.entity.OrderProduct;
import org.example.model.orderProduct.OrderProductRequest;
import org.example.model.orderProduct.OrderProductResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;


import java.util.List;

@Mapper(componentModel = "spring")
@ComponentScan
public interface OrderProductMapper {

    OrderProduct map(OrderProductRequest orderProductRequest);

    OrderProductResponse map(OrderProduct orderProduct);

    List<OrderProductResponse> map(List<OrderProduct> all);

}
