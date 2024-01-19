package com.verystrong.car_loan_project.domain.Application_type;

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


}
