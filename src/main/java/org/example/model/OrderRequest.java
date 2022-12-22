package org.example.model;

import lombok.Data;

@Data
public class OrderRequest {

    private Integer id;
    private Integer personsNumber;
    private String product;
    private Integer price;
}
