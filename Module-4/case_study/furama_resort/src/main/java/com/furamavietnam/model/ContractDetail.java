package com.furamavietnam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail",
        uniqueConstraints = {@UniqueConstraint(name = "CONTRACT_SERVICE_UK", columnNames = {"contract_id", "attach_service_id"})})
@NoArgsConstructor
@Getter
@Setter
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private int contractDetailId;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", nullable = false)
    private AttachService attachService;

    @Column(name = "quantity")
    private int quantity;

}
