package com.verystrong.car_loan_project.domain.Application_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum ApplWeek {
    MON("월"),
    TUE("화"),
    WEN("수"),
    THU("목"),
    SAT("금");

    @Getter
    private final String name;

    private ApplWeek(String name)
    {
        this.name=name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static ApplWeek fromName(String name) {
        for (ApplWeek type : ApplWeek.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + ApplWeek.class.getCanonicalName() + "." + name);
    }
}
