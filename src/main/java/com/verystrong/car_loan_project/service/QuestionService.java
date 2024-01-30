package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.dto.QuestionDto;
import com.verystrong.car_loan_project.entity.QuestionEntity;
import com.verystrong.car_loan_project.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    /**
     * 게시글 목록 가져오기
     */
    public List<QuestionDto> getQuestionList() {
        List<QuestionEntity> questionEntities = questionRepository.findAll();
        List<QuestionDto> dtos = new ArrayList<>();

        for (QuestionEntity entity : questionEntities) {
            QuestionDto dto = QuestionDto.builder()
                    .idx(entity.getIdx())
                    .author(entity.getAuthor())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * 게시글 가져오기
     */
    public QuestionDto getQuestion(Long id) {
        QuestionEntity entity = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return QuestionDto.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .author(entity.getAuthor())
                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }

    /**
     * 게시글 등록
     */
    public QuestionEntity create(QuestionDto questionDto) {
        QuestionEntity entity = QuestionEntity.builder()
                .title(questionDto.getTitle())
                .contents(questionDto.getContents())
                .author(questionDto.getAuthor())
                .createdAt(LocalDateTime.now())
                .build();
        return questionRepository.save(entity);
    }

    /**
     * 게시글 수정
     */
    public QuestionEntity update(QuestionDto questionDto) {
        QuestionEntity entity = questionRepository.findById(questionDto.getIdx()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setTitle(questionDto.getTitle());
        entity.setContents(questionDto.getContents());
        return questionRepository.save(entity);
    }

    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        QuestionEntity entity = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        questionRepository.delete(entity);
    }
}