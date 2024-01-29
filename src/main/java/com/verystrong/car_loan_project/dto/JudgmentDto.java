package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.BaseEntity;
import com.verystrong.car_loan_project.domain.Judgment;
import com.verystrong.car_loan_project.domain.Judgment_type.JudgmentType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class JudgmentDto{

    private Long judgmentId;
    private String accountId;

    private JudgmentType judgment; // 심사결과
    private BigDecimal interestRate; // 예상금리   // TODO: 예상해서 알려주기


    }
