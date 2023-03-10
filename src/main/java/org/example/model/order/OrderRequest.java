package org.example.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.entity.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;

    private String phoneNumber;

    private String address;

    private String customerName;

    private List<Integer> productsId =new ArrayList<>();



}
