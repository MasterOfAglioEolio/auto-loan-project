package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Application_type.InterestType;
import com.verystrong.car_loan_project.domain.Application_type.LoanType;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ApplicationDto {

    private Long applicationId;
    private CustomerInfoDto customerInfo;
    private String accountId;
    private String name;
    private String cellPhone;
    private BigDecimal carPrice;
    private LoanType loanType;
    private Integer deposit;
    private Integer loanTerm;
    private InterestType interestType;
    private BigDecimal interestRate;
//    private LocalDateTime maturity;
//    private BigDecimal HopeAmount;
//    private LocalDateTime appliedAt;
//    private LocalDateTime contractedAt;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private BigDecimal approvalAmount;


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class AcceptTerms {
        List<Long> acceptTermsIds;
    }

}
