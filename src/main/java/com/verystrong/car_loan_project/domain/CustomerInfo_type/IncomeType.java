package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static IncomeType fromName(String name) {
        for (IncomeType type : IncomeType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + IncomeType.class.getCanonicalName() + "." + name);
    }
}
