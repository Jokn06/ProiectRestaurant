package org.example.model.customer;

import lombok.Data;

@Data
public class CustomerResponse {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;
}