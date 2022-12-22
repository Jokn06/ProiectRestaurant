package org.example.model;

import lombok.Data;

@Data
public class OrderResponse {

    private Integer id;
    private Integer personsNumber;
    private String product;
    private Integer price;
}
