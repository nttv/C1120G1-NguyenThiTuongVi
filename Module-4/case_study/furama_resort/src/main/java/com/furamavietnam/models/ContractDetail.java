package com.furamavietnam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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

    public ContractDetail(Contract contract) {
        this.contract = contract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDetail detail = (ContractDetail) o;
        return Objects.equals(contract, detail.contract) &&
                Objects.equals(attachService, detail.attachService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contract, attachService);
    }
}
