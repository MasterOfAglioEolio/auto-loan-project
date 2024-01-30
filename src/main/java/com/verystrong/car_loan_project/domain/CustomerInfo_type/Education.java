package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;



@Getter
public enum Education {
    MiddleSchool("중학교"),
    HighSchool("고등학교"),
    College("전문대"),
    University("대학교"),
    GraduateSchool("대학원");

    private final String name;
    private Education(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Education fromName(String name) {
        for (Education type : Education.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Education.class.getCanonicalName() + "." + name);
    }




}
