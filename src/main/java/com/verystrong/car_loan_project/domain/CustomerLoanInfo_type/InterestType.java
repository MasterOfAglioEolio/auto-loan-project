package com.verystrong.car_loan_project.domain.CustomerLoanInfo_type;

import lombok.Getter;

public enum InterestType {

    Variable("변동"),
    Mixed("혼합"),
    Fixed("고정");

    @Getter
    private final String name;

    private InterestType(String name){
        this.name=name;
    }

}
