package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
@NoArgsConstructor
@Getter
@Setter
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    @Column(name = "service_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ResortService> resortServiceSet;

}
