package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Balance;
import com.verystrong.car_loan_project.domain.Terms;
import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BalanceDto {

    private Long balanceId;
    private Long applicationId;
    private BigDecimal entryAmount;
    private BigDecimal beforeEntryAmount;
    private BigDecimal afterEntryAmount;
    private BigDecimal balance;
    private RepaymentType type;
    private BigDecimal repaymentAmount;

    public Balance toEntity() {
        return new Balance(
                this.balanceId,
                this.applicationId,
                this.balance
        );
    }
    public enum RepaymentType {
        ADD,
        REMOVE
    }
}
