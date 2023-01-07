package org.example.model.order;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderResponse {

    private Integer id;

    @NotBlank
    private Integer personNumber;

    @NotBlank
    private String product;

    @NotBlank
    private Integer price;
}
