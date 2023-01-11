package org.example.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@javax.persistence.Table (name = "t_table")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private Integer capacity;

}
