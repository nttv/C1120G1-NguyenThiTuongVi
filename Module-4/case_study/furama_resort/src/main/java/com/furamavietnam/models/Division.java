package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.furamavietnam.models.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Integer divisionId;

    @Column(name = "division_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String divisionName;

    @OneToMany(mappedBy = "division", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Employee> employeeSet;

}
