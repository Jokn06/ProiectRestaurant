package org.example.model.order;

import lombok.Data;

@Data
public class OrderRequest {

    private Integer id;
    private Integer personNumber;
    private String product;
    private Integer price;
}
