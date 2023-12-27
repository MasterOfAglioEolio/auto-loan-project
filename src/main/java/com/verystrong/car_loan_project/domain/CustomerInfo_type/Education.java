package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import lombok.Getter;



public enum Education {
    MiddleSchool("중학교"),
    HighSchool("고등학교"),
    College("전문대"),
    University("대학교"),
    GraduateSchool("대학원");

    @Getter
    private final String name;
    private Education(String name) {
        this.name = name;
    }




}
