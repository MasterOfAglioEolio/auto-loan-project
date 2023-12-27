package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;

import java.io.Serializable;

/**
 * DTO for {@link com.verystrong.car_loan_project.domain.CustomerInfo}
 */
public record CustomerInfoDto(
        String CustomerName,
        com.verystrong.car_loan_project.domain.CustomerInfo_type.Gender Gender,
        Long Age,
        Education education,
        MaritalStatus martialStatus,
        Integer FamilyCount,
        Integer ChildCount,
        IncomeType incomeType,
        IncomeClass incomeClass,
        Occupation occupation,
        OrgType orgType,
        int EmployedYears,
        boolean HouseOwnedYN,
        DwellingType dwellingType,
        HousingType housingType,
        ResidenceClass residenceClass,
        int HouseAge,
        boolean CarOwnedYN
) implements Serializable {
}