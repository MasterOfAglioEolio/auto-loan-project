package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.BaseEntity;
import com.verystrong.car_loan_project.domain.Judgment;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class JudgmentDto extends BaseEntity {

        private Long applicationId;
        private String name;
        private BigDecimal approvalAmount;
        private Long judgmentId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Judgment toEntity() {
                return new Judgment(
                        this.judgmentId,
                        this.applicationId,
                        this.name,
                        this.approvalAmount
                );

        }
    }
