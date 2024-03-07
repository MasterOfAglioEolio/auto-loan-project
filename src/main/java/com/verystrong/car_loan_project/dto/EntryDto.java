package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Entry;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EntryDto {
    private Long entryId;
    private Long applicationId;
    private String accountId;
    private BigDecimal entryAmount;
    private BigDecimal beforeEntryAmount;
    private BigDecimal afterEntryAmount;


}
