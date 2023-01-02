package org.example.model.menu;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class MenuRequest {

    private Integer id;

    @NotBlank
    private String productName;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    @Positive
    private String weight ;

}
