package org.example.model.product;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class RequestUpdatePrice {

    private Integer id;

//    @NotNull
    @Positive
    private Integer productPrice;

}
