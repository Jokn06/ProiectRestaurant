package org.example.model.customer;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequest {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;
}
