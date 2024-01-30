package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Gender {
    Man("남자"),
    Woman("여자");

    private final String name;
    private Gender(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Gender fromName(String name) {
        for (Gender type : Gender.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Gender.class.getCanonicalName() + "." + name);
    }
}
