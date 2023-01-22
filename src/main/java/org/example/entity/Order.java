package org.example.entity;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @FutureOrPresent
    @Column(name = "start_date")
    private LocalDateTime dateStart;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "order_services",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @Builder.Default
    private Set<Order> orders = new HashSet<>();

}
