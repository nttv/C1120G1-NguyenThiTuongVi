package com.furamavietnam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "service")
@NoArgsConstructor
@Getter
@Setter
public class ResortService {

    @Id
    @Column(name = "service_id", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^DV-\\d{4}$",
            message = "Service ID must be in DV-XXXX format. (i.e: DV-1234)")
    private String serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    @NotBlank(message = "Service name must not be empty.")
    private String serviceName;

    @Column(name = "service_area", columnDefinition = "INT NOT NULL")
    @Pattern(regexp = "^[1-9]\\d*$",
            message = "Area must be a positive number.")
    private String serviceArea;

    @Column(name = "service_cost", columnDefinition = "DOUBLE NOT NULL")
    @Pattern(regexp = "^[1-9]\\d*(\\.\\d+)?$",
            message = "Service cost must be a positive number.")
    private String serviceCost;

    @Column(name = "service_max_people", columnDefinition = "INT NOT NULL")
    @Pattern(regexp = "^[1-9]\\d*$",
            message = "Number of people must be a positive number.")
    private String serviceMaxPeople;

    @Column(name = "room_standard", columnDefinition = "VARCHAR(45)")
    private String roomStandard;

    @Column(name = "description_other_convenience", columnDefinition = "VARCHAR(45)")
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    @Min(value = 0, message = "Area must be a positive number.")
    private int poolArea;

    @Column(name = "number_of_floors")
    @Min(value = 0, message = "Number of floors must be a positive number.")
    private int numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "resortService", cascade = CascadeType.REMOVE)
    private Set<Contract> contractSet;

}
