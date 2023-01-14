package org.example.entity;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

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


    @PastOrPresent(message = "Please check the date")
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @PastOrPresent(message = "Please check the date")
    @Column(name = "order_completed")
    private LocalDateTime orderCompleted;

//    @ManyToOne
//    @Column(name = "table_id" )
//    private org.example.entity.Table table;



//  @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "order")
//  @Builder.Default
//    private List<Product> products = new ArrayList<>();

//
//  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "order_services",
//            joinColumns = {@JoinColumn(name= "chef_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})

 }
