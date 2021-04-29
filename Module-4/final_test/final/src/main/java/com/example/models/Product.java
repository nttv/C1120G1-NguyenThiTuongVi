package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", columnDefinition = "VARCHAR(45) NOT NULL")
    @NotBlank(message = "Customer name must not be empty.")
    private String productName;

    @Column(name = "product_cost")
    private int productCost;

    @Column(name = "product_status", columnDefinition = "VARCHAR(45) NOT NULL")
    private String productStatus;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    @OneToOne(mappedBy = "product")
    @JsonIgnore
    private Order order;

}
