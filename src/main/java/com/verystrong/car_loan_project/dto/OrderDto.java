package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Application_type.InterestType;
import com.verystrong.car_loan_project.domain.Application_type.LoanType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OrderDto {
    private String name;
    private String address;
    private String cellPhone;
    private BigDecimal carPrice;
    private LoanType loanType;
    private Integer deposit;
    private Integer loanTerm;
    private InterestType interestType;
    private BigDecimal interestRate;
    private String items;
    private LocalDateTime maturity;
    private LocalDateTime appliedAt;
    private LocalDateTime contractedAt;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    private BigDecimal approvalAmount;
}
