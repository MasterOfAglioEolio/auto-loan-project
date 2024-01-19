package com.verystrong.car_loan_project.domain;

import com.verystrong.car_loan_project.domain.Judgment_type.JudgmentType;
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

    private JudgmentType judgment; // 심사결과

    @Column(columnDefinition = "decimal(5,4)")
    private BigDecimal interestRate; // 예상금리   // TODO: 예상해서 알려주기

}
