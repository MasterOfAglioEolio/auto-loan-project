package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import lombok.Getter;

public enum Occupation {
    Cleaning_Laundering("청소/세탁"),
    Personnel_Manager("인사담당"),
    estate_agent("부동산중개인"),
    accounting("회계"),
    DailyJob("일용직"),
    Secretary("비서직"),
    Cooking("요리"),
    Security("보안"),
    Professional_technology("전문기술"),
    IT_development_management("IT개발/관리"),
    Driving("운전"),
    Manager("매니저"),
    General_work("일반업무"),
    Waiter("웨이터"),
    Labor("노동"),
    Pharmaceutical("제약"),
    Sales("영업"),
    PersonalService("개인서비스"),
    Other("기타");

    @Getter
    private final String name;

    private Occupation(String name)
    {
        this.name=name;
    }





}
