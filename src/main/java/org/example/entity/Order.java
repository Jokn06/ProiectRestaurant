package org.example.entity;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Table;

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


//  @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "order")
//  @Builder.Default
//    private List<Product> products = new ArrayList<>();

//
//  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "order_services",
//            joinColumns = {@JoinColumn(name= "chef_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})

 }
