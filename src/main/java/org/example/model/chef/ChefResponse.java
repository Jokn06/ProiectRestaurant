package org.example.model.chef;

import lombok.Data;
import java.time.LocalDate;

@Data

public class ChefResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate birthDay;
    private String phoneNumber;
    private LocalDate hireDate;



}
