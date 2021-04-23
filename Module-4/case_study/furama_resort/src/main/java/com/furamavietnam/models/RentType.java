package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
@NoArgsConstructor
@Getter
@Setter
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;

    @Column(name = "rent_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String rentTypeName;

    @Column(name = "rent_type_cost", nullable = false)
    private double rentTypeCost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ResortService> resortServiceSet;

}
