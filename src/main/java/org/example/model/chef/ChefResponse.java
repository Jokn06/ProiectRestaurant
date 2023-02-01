package org.example.model.chef;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data

public class ChefResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate hireDate;



}
