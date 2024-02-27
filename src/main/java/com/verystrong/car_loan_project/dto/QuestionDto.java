package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.entity.CommentEntity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class QuestionDto{

    private Long questionId;
    private List<CommentEntity> comments;
    private String title;
    private String content;
    private String createdAt;

}