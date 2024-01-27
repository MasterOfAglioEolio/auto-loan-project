package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static ResidenceClass fromName(String name) {
        for (ResidenceClass type : ResidenceClass.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + ResidenceClass.class.getCanonicalName() + "." + name);
    }

}
