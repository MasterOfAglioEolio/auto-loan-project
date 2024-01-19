package com.verystrong.car_loan_project.response;

import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;

import java.io.Serializable;

public record CustomerInfoResponse(  Long id,
                                     Gender gender,
                                     float Age,
                                     Education education,
                                     MaritalStatus martialStatus,
                                     Integer FamilyCount,
                                     Integer ChildCount,
                                     IncomeType incomeType,
                                     IncomeClass incomeClass,
                                     Occupation occupation,
                                     OrgType orgType,
                                     float EmployedYears,
                                     HouseOwnedYN houseOwnedYN,
                                     DwellingType dwellingType,
                                     HousingType housingType,
                                     ResidenceClass residenceClass,
                                     float HouseAge,
                                     CarOwnedYN carOwnedYN) implements Serializable {

    public static CustomerInfoResponse of(
            Long id,
            Gender gender,
            float Age,
            Education education,
            MaritalStatus martialStatus,
            Integer FamilyCount,
            Integer ChildCount,
            IncomeType incomeType,
            IncomeClass incomeClass,
            Occupation occupation,
            OrgType orgType,
            float EmployedYears,
            HouseOwnedYN houseOwnedYN,
            DwellingType dwellingType,
            HousingType housingType,
            ResidenceClass residenceClass,
            float HouseAge,
            CarOwnedYN carOwnedYN

    ){
        return new CustomerInfoResponse(id,
                gender,
                Age,
                education,
                martialStatus,
                FamilyCount,
                ChildCount,
                incomeType,
                incomeClass,
                occupation,
                orgType,
                EmployedYears,
                houseOwnedYN,
                dwellingType,
                housingType,
                residenceClass,
                HouseAge,
                carOwnedYN);
    }


    //TODO : 회원 가입 연동 시 추가
//    public static CustomerInfoResponse from(CustomerInfoDto dto)
//    {
//        String id == dto.
//    }
//
}
