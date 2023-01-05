package org.example.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
   // @Column (name = "number")
    private Integer number;

    @NotBlank
    private Integer seat;

@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "table")
    private List<Person> persons;
}
