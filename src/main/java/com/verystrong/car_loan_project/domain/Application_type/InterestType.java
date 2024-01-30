package com.verystrong.car_loan_project.domain.Application_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static InterestType fromName(String name) {
        for (InterestType type : InterestType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + InterestType.class.getCanonicalName() + "." + name);
    }

}
