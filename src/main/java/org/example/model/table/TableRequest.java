package org.example.model.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableRequest {

    private Integer id;

    @NotBlank(message = "Invalid table name!")
    private String name;

//    @NotBlank(message = "Invalid capacity!")
//    @Positive
    private Integer capacity;

}
