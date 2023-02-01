package org.example.model.chef;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.time.LocalDate;


@Data
public class CreateChefRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Past(message = "Hire date must be less that today")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate hireDate;
}
