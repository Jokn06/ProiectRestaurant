package org.example.model.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class UpdateProductRequest {

    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private String weight;

    @Positive
    private Integer price;

}
