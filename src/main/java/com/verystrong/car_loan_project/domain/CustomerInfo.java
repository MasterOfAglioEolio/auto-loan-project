package com.verystrong.car_loan_project.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList="CustomerId"),
        @Index(columnList="CustomerName")
})
@Entity
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerId;

    @Column(nullable = false, length = 20) // 기본정보는 null false
    private String CustomerName;
    @Column(nullable = false)
    private Gender Gender;
    @Column(nullable = false)
    private Long Age;

    private Education education;
    private MartialStatus martialStatus;
    private Integer FamilyCount;
    private Integer ChildCount;

    @Setter  // 수정 가능한 데이터 Setter 설정
    private IncomeType incomeType;
    @Setter private IncomeClass incomeClass;
    @Setter private Occupation occupation;
    @Setter private OrgType orgType;

    @Setter private int EmployedYears;
    @Setter private boolean HouseOwnedYN;
    @Setter private DwellingType dwellingType;
    @Setter private HosingType hosingType;
    @Setter private ResidenceClass residenceClass;

    @Setter private int HouseAge;
    @Setter private boolean CarOwnedYN;

    private CustomerInfo(String customerName,
                        Gender gender,
                        Long age, Education education,
                        MartialStatus martialStatus,
                        Integer familyCount,
                        Integer childCount,
                        IncomeType incomeType,
                        IncomeClass incomeClass,
                        Occupation occupation,
                        OrgType orgType,
                        int employedYears,
                        boolean houseOwnedYN,
                        DwellingType dwellingType,
                        HosingType hosingType,
                        ResidenceClass residenceClass,
                        int houseAge,
                        boolean carOwnedYN) {
        CustomerName = customerName;
        Gender = gender;
        Age = age;
        this.education = education;
        this.martialStatus = martialStatus;
        FamilyCount = familyCount;
        ChildCount = childCount;
        this.incomeType = incomeType;
        this.incomeClass = incomeClass;
        this.occupation = occupation;
        this.orgType = orgType;
        EmployedYears = employedYears;
        HouseOwnedYN = houseOwnedYN;
        this.dwellingType = dwellingType;
        this.hosingType = hosingType;
        this.residenceClass = residenceClass;
        HouseAge = houseAge;
        CarOwnedYN = carOwnedYN;
    }

    public static CustomerInfo of(String customerName,
                        Gender gender,
                        Long age, Education education,
                        MartialStatus martialStatus,
                        Integer familyCount,
                        Integer childCount,
                        IncomeType incomeType,
                        IncomeClass incomeClass,
                        Occupation occupation,
                        OrgType orgType,
                        int employedYears,
                        boolean houseOwnedYN,
                        DwellingType dwellingType,
                        HosingType hosingType,
                        ResidenceClass residenceClass,
                        int houseAge,
                        boolean carOwnedYN) {
       return new CustomerInfo(customerName,gender,age,education,martialStatus,familyCount,
               childCount,incomeType,incomeClass,occupation,orgType,employedYears,houseOwnedYN,
               dwellingType,hosingType,residenceClass,houseAge,carOwnedYN);

    }

    protected CustomerInfo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerInfo that)) return false;
        return CustomerId != null && Objects.equals(CustomerId, that.CustomerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerId);
    }
}
