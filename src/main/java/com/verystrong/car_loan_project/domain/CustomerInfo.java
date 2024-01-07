package com.verystrong.car_loan_project.domain;


import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Setter
@Getter
@ToString
@AllArgsConstructor	// 모든 컬럼 생성자 생성
@NoArgsConstructor	// 기본 생성자
@Table(indexes = {
        @Index(columnList="CustomerId")
//        @Index(columnList="CustomerName")
})
@Builder
@Entity
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerId;
//
//    @Setter
//    @Column(nullable = false, length = 20) // 기본정보는 null false
//    private String CustomerName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(nullable = false)
    private float Age;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Education education;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(nullable = false)
    private Integer FamilyCount;

    @Column(nullable = false)
    private Integer ChildCount;

  // 수정 가능한 데이터 Setter 설정 권장하진 않음
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IncomeClass incomeClass;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrgType orgType;

    @Column(nullable = true)
    private float EmployedYears;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HouseOwnedYN houseOwnedYN;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DwellingType dwellingType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HousingType housingType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResidenceClass residenceClass;

    @Column(nullable = true)
    private float HouseAge;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarOwnedYN carOwnedYN;

//    private CustomerInfo(
////            String customerName,
//            Gender gender,
//            float age, Education education,
//            MaritalStatus maritalStatus,
//            Integer familyCount,
//            Integer childCount,
//            IncomeType incomeType,
//            IncomeClass incomeClass,
//            Occupation occupation,
//            OrgType orgType,
//            float employedYears,
//            HouseOwnedYN houseOwnedYN,
//            DwellingType dwellingType,
//            HousingType housingType,
//            ResidenceClass residenceClass,
//            float houseAge,
//            CarOwnedYN carOwnedYN) {
////        CustomerName = customerName;
//        this.gender = gender;
//        Age = age;
//        this.education = education;
//        this.maritalStatus = maritalStatus;
//        FamilyCount = familyCount;
//        ChildCount = childCount;
//        this.incomeType = incomeType;
//        this.incomeClass = incomeClass;
//        this.occupation = occupation;
//        this.orgType = orgType;
//        EmployedYears = employedYears;
//        this.houseOwnedYN = houseOwnedYN;
//        this.dwellingType = dwellingType;
//        this.housingType = housingType;
//        this.residenceClass = residenceClass;
//        HouseAge = houseAge;
//        this.carOwnedYN = carOwnedYN;
//    }
//
//    public static CustomerInfo of(
////            String customerName,
//            Gender gender,
//            float age, Education education,
//            MaritalStatus maritalStatus,
//            Integer familyCount,
//            Integer childCount,
//            IncomeType incomeType,
//            IncomeClass incomeClass,
//            Occupation occupation,
//            OrgType orgType,
//            float employedYears,
//            HouseOwnedYN houseOwnedYN,
//            DwellingType dwellingType,
//            HousingType housingType,
//            ResidenceClass residenceClass,
//            float houseAge,
//            CarOwnedYN carOwnedYN) {
//        return new CustomerInfo(
////               customerName,
//                gender,
//                age,
//                education,
//                maritalStatus,
//                familyCount,
//                childCount,
//                incomeType,
//                incomeClass,
//                occupation,
//                orgType,
//                employedYears,
//                houseOwnedYN,
//                dwellingType,
//                housingType,
//                residenceClass,
//                houseAge,
//                carOwnedYN);
//
//    }
//
//    protected CustomerInfo() {
//
//    }


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
