package org.example.model.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

//    @NotNull
    @Positive
    private Integer price;

    @NotNull
    @Positive
    private String weight;

}
