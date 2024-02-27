package com.verystrong.car_loan_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(indexes = {
        @Index(columnList="CommentId")
})
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    private String content;
    private LocalDateTime createdAt;
}

