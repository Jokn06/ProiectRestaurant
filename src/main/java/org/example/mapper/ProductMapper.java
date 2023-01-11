package org.example.mapper;

import org.example.entity.Product;
import org.example.model.product.ProductRequest;
import org.example.model.product.ProductResponse;
import org.example.model.product.RequestUpdatePrice;
import org.example.model.product.UpdateName;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(ProductRequest productRequest);

    ProductResponse map(Product product);

    List<ProductResponse> map(List<Product> all);

    Product map(RequestUpdatePrice requestUpdatePrice);

    Product map(UpdateName updateName);


}
