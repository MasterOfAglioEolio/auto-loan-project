package com.verystrong.car_loan_project.domain.CustomerInfo_type;

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

}
