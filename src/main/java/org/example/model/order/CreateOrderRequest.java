package org.example.model.order;

import lombok.Data;
import org.example.entity.Customer;

import javax.persistence.Column;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class CreateOrderRequest {
    private Integer id;

    private LocalDateTime dateStart;

    private String phoneNumber;

    private String address;

    private Customer customer;
}
