package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import lombok.Getter;

@Getter
public enum MaritalStatus {
    Single("독신"),
    Married("결혼"),
    Divorced("이혼"),
    Bereaved("사별");

    private final String name;
    private MaritalStatus(String name) {
        this.name = name;
    }

}
