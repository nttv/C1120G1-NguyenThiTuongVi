package com.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

//    @Column(name = "order_date", columnDefinition = "DATE")
//    private String orderDate;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

}
