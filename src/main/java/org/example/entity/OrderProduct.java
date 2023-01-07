package org.example.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @FutureOrPresent
    @Column(name ="start_date" )
    private LocalDateTime dateStart;

    @FutureOrPresent
    @Column(name = "delivered_date")
    private LocalDateTime delivered;

    @FutureOrPresent
    @Column (name = "canceled_date" )
    private LocalDateTime canceled;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}
