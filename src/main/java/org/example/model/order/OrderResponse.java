package org.example.model.order;

import lombok.Data;
import org.example.entity.Customer;
import org.example.model.customer.CustomerResponseForOrder;
import org.example.model.product.ProductResponse;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class OrderResponse {

    private Integer id;

    private String customerName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dateStart;

    private String phoneNumber;

    private String address;

}
