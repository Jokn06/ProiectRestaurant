package org.example.model.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdatePrice {

    private Integer id;

    @NotBlank
    private Integer productPrice;

}
