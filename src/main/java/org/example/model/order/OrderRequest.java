package org.example.model.order;

import lombok.Data;

import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
public class OrderRequest {

    private Integer id;
    private LocalDateTime orderDate;
    private LocalDateTime orderCompleted;
    private Table table;
}
