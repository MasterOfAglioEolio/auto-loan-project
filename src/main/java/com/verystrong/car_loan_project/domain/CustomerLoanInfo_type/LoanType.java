package com.verystrong.car_loan_project.domain.CustomerLoanInfo_type;

import lombok.Getter;


public enum LoanType {

    LoanFinancingType("할부금융(장/단기)"),
    Autoron("오토론");

    @Getter
    private final String name;

    private LoanType(String name){
        this.name=name;
    }
}
