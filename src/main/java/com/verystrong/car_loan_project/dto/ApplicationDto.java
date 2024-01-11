package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Application_type.InterestType;
import com.verystrong.car_loan_project.domain.Application_type.LoanType;
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
    private String name;
    private String cellPhone;
    private String email;
    private BigDecimal carPrice;
    private LoanType loanType;
    private Integer deposit;
    private Integer loanTerm;
    private InterestType interestType;
    private BigDecimal interestRate;
    private BigDecimal fee;
    private LocalDateTime maturity;
    private BigDecimal hopeAmount;
    private LocalDateTime appliedAt;
    private LocalDateTime contractedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BigDecimal approvalAmount;

    public Application toEntity() {
        return new Application(
                this.applicationId,
                this.name,
                this.cellPhone,
                this.email,
                this.carPrice,
                loanType,
                this.deposit,
                this.loanTerm,
                interestType,
                this.interestRate,
                this.fee,
                this.maturity,
                this.hopeAmount,
                this.appliedAt,
                this.approvalAmount,
                this.contractedAt
        );

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class AcceptTerms {
        List<Long> acceptTermsIds;
    }

}
