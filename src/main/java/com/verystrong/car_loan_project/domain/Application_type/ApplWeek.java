package com.verystrong.car_loan_project.domain.Application_type;

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
}
