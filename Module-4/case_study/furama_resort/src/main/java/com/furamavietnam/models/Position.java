package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String positionName;

    @OneToMany(mappedBy = "position", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Employee> employeeSet;

}
