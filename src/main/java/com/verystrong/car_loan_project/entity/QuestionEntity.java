package com.verystrong.car_loan_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(indexes = {
        @Index(columnList="QuestionId")
})

@Entity
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;


    private String title;
    private String content;
    private LocalDateTime createdAt;
}

