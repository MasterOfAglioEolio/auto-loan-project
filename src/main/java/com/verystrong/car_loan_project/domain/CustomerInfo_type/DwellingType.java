package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DwellingType {

    Self("자가"),
    Monthly_rent("월세"),
    Family_joint("가족공동"),
    Charter("전세"),
    Half_Charter("반전세"),
    N("정보누락"),
    Public_long_term_rental("공공장기임대");

    private final String name;
    private DwellingType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static DwellingType fromName(String name) {
        for (DwellingType type : DwellingType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + DwellingType.class.getCanonicalName() + "." + name);
    }
}
