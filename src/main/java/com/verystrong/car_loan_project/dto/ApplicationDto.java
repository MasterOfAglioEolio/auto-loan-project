package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Application;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationDto {

    private Long applicationId;
    private String name;
    private String cellPhone;
    private String email;
    private BigDecimal interestRate;
    private BigDecimal fee;
    private LocalDateTime maturity;
    private BigDecimal hopeAmount;
    private LocalDateTime appliedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Application toEntity() {
        return new Application(
                this.applicationId,
                this.name,
                this.cellPhone,
                this.email,
                this.interestRate,
                this.fee,
                this.maturity,
                this.hopeAmount,
                this.appliedAt
        );

    }

}
