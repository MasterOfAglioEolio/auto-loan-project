package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.CustomerLoanInfo;
import com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * DTO for {@link CustomerLoanInfo}
 */
public record CustomerLoanInfoDto(
        boolean defaultYN,
        ActiveLoanYN activeLoanYN,
        LoanType loanType,
        DayOfWeek applWeek,
        LocalTime applHour,
        Accompany accompany,
        BigDecimal CarPrice,
        int deposit,
        int loanTerm,
        int loanRemainTerm,
        InterestType interestType,
        float interestRate,
        BigDecimal loanAmount,
        BigDecimal installAmount,
        BigDecimal loanRemainAmount
) implements Serializable {
}