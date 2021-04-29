package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_type")
@NoArgsConstructor
@Getter
@Setter
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer productTypeId;

    @Column(name = "product_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String productTypeName;

    @OneToMany(mappedBy = "productType")
    @JsonIgnore
    private Set<Product> productSet;

}
