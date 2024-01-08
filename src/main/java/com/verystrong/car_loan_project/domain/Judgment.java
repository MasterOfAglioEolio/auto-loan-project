package com.verystrong.car_loan_project.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Judgment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long judgmentId;

    private Long applicationId; // 신청 id

    private String name; // 심사자

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal approvalAmount; // 승인금액

    @Column(columnDefinition = "decimal(5,4)")
    private BigDecimal approvalInterestRate; //'승인 금리'
}
