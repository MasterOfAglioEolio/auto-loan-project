package com.verystrong.car_loan_project.domain.Judgment_type;

import lombok.Getter;

@Getter
public enum JudgmentType {
    pass("pass"), fail("fail");

    private final String name;
    private JudgmentType(String name) {
        this.name = name;
    }
}
