package com.verystrong.car_loan_project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.domain.Terms;
import lombok.*;

import java.time.LocalDateTime;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Getter
@Setter
public class TermsDto {
    private Long termsId;

    private String name; //약관명

    private String termsDetailUrl; //약관상세 URL


    public Terms toEntity() {
        return new Terms(
            this.termsId,
            this.name,
            this.termsDetailUrl

    );
    }
}
