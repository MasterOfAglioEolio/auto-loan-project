package com.verystrong.car_loan_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto implements Serializable {

    private Long questionId;
    private String accountId;
    private String title;
    private String content;
    private String createdAt;
}