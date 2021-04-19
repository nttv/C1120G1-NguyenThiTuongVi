package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
@NoArgsConstructor
@Getter
@Setter
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer customerTypeId;

    @Column(name = "customer_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    @JsonIgnore
    private Set<Customer> customerSet;

}
