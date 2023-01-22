package org.example.model.product;

import lombok.Data;

@Data
public class CreateProductRequest {
    private Integer id;

    private String name;

    private String weight;

    private Integer price;

}
