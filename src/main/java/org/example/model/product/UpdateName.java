package org.example.model.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateName {

    private Integer id;

    @NotBlank
    private String productName;

}
