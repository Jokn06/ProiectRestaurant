package org.example.model.chef;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChefRequest {


    private Integer id;

    @NotBlank(message = "Invalid first name!")
    private String firstName;

    @NotBlank(message = "Invalid last name!")
    private String lastName;


    @NotBlank
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past(message = "Hire date must be less that today")
    private LocalDateTime hireDate;
}
