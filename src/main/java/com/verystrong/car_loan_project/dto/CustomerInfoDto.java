package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CustomerInfoDto {

    private Long customerId;
    private Gender gender;
    private float Age;
    private Education education;
    private MaritalStatus maritalStatus;
    private Integer FamilyCount;
    private Integer ChildCount;
    private IncomeType incomeType;
    private IncomeClass incomeClass;
    private Occupation occupation;
    private OrgType orgType;
    private float EmployedYears;
    private HouseOwnedYN houseOwnedYN;
    private DwellingType dwellingType;
    private HousingType housingType;
    private ResidenceClass residenceClass;
    private float HouseAge;
    private CarOwnedYN carOwnedYN;








}