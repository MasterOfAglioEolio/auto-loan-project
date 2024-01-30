package com.verystrong.car_loan_project.domain.Application_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.IncomeClass;
import lombok.Getter;

public enum Accompany {
    Other("기타"),
    Child("자녀"),
    Group("단체"),
    Spouse("배우자"),
    Relative("친지"),
    Solo("단독");

    @Getter
    private final String name;

    private Accompany(String name)
    {
        this.name=name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Accompany fromName(String name) {
        for (Accompany type : Accompany.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Accompany.class.getCanonicalName() + "." + name);
    }


}
