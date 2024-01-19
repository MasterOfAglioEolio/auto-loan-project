package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import lombok.Getter;

@Getter
public enum ResidenceClass {
    Good("양호"),
    Average("평균"),
    Best("최상"),
    N("누락");

    private final String name;
    private ResidenceClass(String name) {
        this.name = name;
    }

}
