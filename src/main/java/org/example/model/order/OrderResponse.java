package org.example.model.order;

import lombok.Data;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class OrderResponse {

    private Integer id;

    @NotBlank
    private LocalDateTime orderDate;

    @NotBlank
    private LocalDateTime orderCompleted;
    
    @NotBlank
    private Table table;
}
