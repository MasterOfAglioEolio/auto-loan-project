package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum IncomeClass {
    A("1.5억원 이상"),
    B("1억원~1.5억원 미만"),
    C("5000만원~1억원 미만"),
    D("4000만원~5000만원 미만"),
    E("3000만원~4000만원 미만"),
    F("2000만원~3000만원 미만"),
    G("1000만원~2000만원 미만"),
    H("1000만원 미만"),
    N("누락");

    private final String name;

    private IncomeClass(String name)
    {
        this.name=name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static IncomeClass fromName(String name) {
        for (IncomeClass type : IncomeClass.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + IncomeClass.class.getCanonicalName() + "." + name);
    }

}
