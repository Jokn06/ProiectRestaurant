package org.example.model.chef;

import lombok.Data;

import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Data
public class UpdateChefRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Past(message = "Hire date must be less that today")
    private LocalDateTime hireDate;


}
