package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import lombok.Getter;

@Getter
public enum IncomeType {
    Service("서비스"),
    Other("기타"),
    Business("사업"),
    PublicServants("공무원"),
    Retirement("퇴직");

    private final String name;

    private IncomeType(String name) {
        this.name = name;
    }
}
