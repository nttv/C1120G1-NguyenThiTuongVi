package com.furamavietnam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Contract implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_start_date", columnDefinition = "DATE NOT NULL")
    private String contractStartDate;

    @Column(name = "contract_end_date", columnDefinition = "DATE")
    private String contractEndDate;

    @Column(name = "contract_deposit")
    @Min(value = 0, message = "Deposit must be a positive number.")
    private double contractDeposit;

    @Column(name = "contract_total_money")
    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @NotNull(message = "Resort service field must not be empty.")
    private ResortService resortService;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @NotNull(message = "Employee field must not be empty.")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull(message = "Customer field must not be empty.")
    private Customer customer;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<ContractDetail> contractDetails;

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        if (contract.contractStartDate.equals("")) {
            errors.rejectValue("contractStartDate", "start.date.null");
        } else if (contract.contractEndDate.equals("")) {
            errors.rejectValue("contractEndDate", "end.date.null");
        } else {
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.contractStartDate);
                Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.contractEndDate);
                if (startDate.compareTo(endDate) > 0) {
                    errors.rejectValue("contractStartDate", "start.date.after");
                    errors.rejectValue("contractEndDate", "end.date.before");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
