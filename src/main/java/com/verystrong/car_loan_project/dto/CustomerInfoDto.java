package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;

import java.io.Serializable;

/**
 * DTO for {@link com.verystrong.car_loan_project.domain.CustomerInfo}
 */
public record CustomerInfoDto(
//        String CustomerName,
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
) {
    public static CustomerInfoDto of(Gender gender,
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
                           CarOwnedYN carOwnedYN) {
       return new CustomerInfoDto(gender,
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
}