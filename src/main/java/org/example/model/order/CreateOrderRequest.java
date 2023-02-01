package org.example.model.order;

import lombok.Data;
import org.example.entity.Customer;

import javax.persistence.Column;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateOrderRequest {

    private List<Integer> orders;
}

