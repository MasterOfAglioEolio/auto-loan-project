package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Repayment;
import com.verystrong.car_loan_project.domain.Terms;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RepaymentDto {
    private Long repaymentId;
    private Long applicationId;
    private String accountId;
    private BigDecimal repaymentAmount;
    private BigDecimal beforeRepaymentAmount;
    private BigDecimal afterRepaymentAmount;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
