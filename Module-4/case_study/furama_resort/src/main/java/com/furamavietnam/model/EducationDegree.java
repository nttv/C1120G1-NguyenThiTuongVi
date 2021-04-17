package com.furamavietnam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_degree")
@NoArgsConstructor
@Getter
@Setter
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer degreeId;

    @Column(name = "education_degree_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String degreeName;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employeeSet;
}
