package org.example.model.product;

import lombok.Data;

@Data
public class ProductResponse {

    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private String weight ;


}
