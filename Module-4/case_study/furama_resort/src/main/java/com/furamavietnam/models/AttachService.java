package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_service")
@NoArgsConstructor
@Getter
@Setter
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;

    @Column(name = "attach_service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String attachServiceName;

    @Column(name = "attach_service_cost", nullable = false)
    private double attachServiceCost;

    @Column(name = "attach_service_unit", columnDefinition = "VARCHAR(15) NOT NULL")
    private String attachServiceUnit;

    @Column(name = "attach_service_status", columnDefinition = "VARCHAR(45) NOT NULL")
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ContractDetail> contractDetails;

}
