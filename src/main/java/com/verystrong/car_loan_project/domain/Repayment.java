package com.verystrong.car_loan_project.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Repayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long repaymentId;

    private Long applicationId; // 신청 ID

    private String accountId;

    @Column(columnDefinition = "decimal(15, 2)")
    private BigDecimal repaymentAmount; // 상황 금액

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal balance;

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal beforeRepaymentAmount;

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal afterRepaymentAmount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedAt;
}
