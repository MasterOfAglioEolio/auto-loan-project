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
    private Long customerId;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(nullable = false)
    private float age;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Education education;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(nullable = false)
    private Integer familyCount;

    @Column(nullable = false)
    private Integer childCount;

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
    private float employedYears;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarOwnedYN carOwnedYN;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerInfo that)) return false;
        return customerId != null && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }


}
