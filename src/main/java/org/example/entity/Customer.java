package org.example.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@javax.persistence.Table(name = "customer")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class  Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "customer")
    private List<Order> orders;
}
