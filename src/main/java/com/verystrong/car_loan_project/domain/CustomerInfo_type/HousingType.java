package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum HousingType {

    Related_multifamily_villa("연립/다세대/빌라"),
    Officetel("오피스텔"),
    Apartment("아파트"),
    Detached_house("단독주택");


    private final String name;
    private HousingType(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static HousingType fromName(String name) {
        for (HousingType type : HousingType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + HousingType.class.getCanonicalName() + "." + name);
    }

}
