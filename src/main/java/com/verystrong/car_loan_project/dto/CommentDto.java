package com.verystrong.car_loan_project.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Long commentId;
    private String accountId;
    private Long questionId;
    private String content;
    private String createdAt;
}

