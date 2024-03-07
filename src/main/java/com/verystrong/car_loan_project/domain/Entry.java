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
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long entryId;

    private Long applicationId; // 신청 ID

    private String accountId;

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal entryAmount;// 집행금액

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal beforeEntryAmount;
    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal afterEntryAmount;
}
