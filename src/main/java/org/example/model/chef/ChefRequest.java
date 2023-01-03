package org.example.model.chef;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

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

    @NotBlank(message = "Invalid address name!")
    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past(message = "BirthDay must be less that today")
    private LocalDate birthDay;

    @NotBlank
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past(message = "Hire date must be less that today")
    private LocalDate hireDate;
}
