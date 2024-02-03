package com.verystrong.car_loan_project.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Long idx;
    private String contents;
    private String createdAt;
}

