package org.example.entity;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private Integer personsNumber;

    @NotBlank
    private String product;

    @NotBlank
    private Integer price;

  @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "order")
    private List<Product> products;

//
//  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "order_services",
//            joinColumns = {@JoinColumn(name= "chef_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})

 }
