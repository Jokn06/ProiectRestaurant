package org.example.entity;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String productName;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    @Positive
    private String weight ;

   @ManyToOne(fetch = FetchType.LAZY)
    private Order order;



}
