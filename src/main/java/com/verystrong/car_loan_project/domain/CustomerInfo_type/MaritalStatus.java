package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static MaritalStatus fromName(String name) {
        for (MaritalStatus type : MaritalStatus.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + MaritalStatus.class.getCanonicalName() + "." + name);
    }

}
