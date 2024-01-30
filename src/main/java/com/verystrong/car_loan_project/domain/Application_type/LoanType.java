package com.verystrong.car_loan_project.domain.Application_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;


public enum LoanType {

    LoanFinancingType("할부금융(장/단기)"),
    Autoron("오토론");

    @Getter
    private final String name;

    private LoanType(String name){
        this.name=name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static LoanType fromName(String name) {
        for (LoanType type : LoanType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + LoanType.class.getCanonicalName() + "." + name);
    }
}
