package com.verystrong.car_loan_project.domain.CustomerInfo_type;

import lombok.Getter;

@Getter
public enum OrgType {

    General("일반"),
    Transport("운송"),
    Service("서비스"),
    Bank_insurance("은행/보험"),
    Self_employed("자영업"),
    Pharmaceutical("제약"),
    Kindergarten("유치원"),
    Trade("무역"),
    Industry("산업"),
    Public("공공"),
    Army_Police("군/경"),
    Construction("건설"),
    Security("보안"),
    Others("기타"),
    Communications("통신"),
    Agriculture("농업"),
    Education("교육"),
    Cleaning_Laundering("청소/세탁"),
    Foreign_Community("외국계");

    private final String name;
    private OrgType(String name) {
        this.name = name;
    }


}
