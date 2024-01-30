package com.verystrong.car_loan_project.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
public class AcceptTerms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    @EqualsAndHashCode.Include
    private Long acceptTermsId;

    @Column(nullable = false)
    private Long applicationId; // 신청 ID

    @Column(nullable = false)
    private Long termsId; // 약관 ID
}
