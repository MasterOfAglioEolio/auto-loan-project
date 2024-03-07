package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Balance;
import com.verystrong.car_loan_project.domain.Terms;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BalanceDto {

    private Long balanceId;
    private Long applicationId;
    private String accountId;
    private BigDecimal entryAmount;
    private BigDecimal beforeEntryAmount;
    private BigDecimal afterEntryAmount;
    private BigDecimal balance;
    private BigDecimal repaymentAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
