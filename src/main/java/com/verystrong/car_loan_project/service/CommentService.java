package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.dto.CommentDto;
import com.verystrong.car_loan_project.entity.CommentEntity;
import com.verystrong.car_loan_project.repository.CommentRepository;
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
public class CommentService {
    private final CommentRepository commentRepository;

    /**
     * 댓글 목록 가져오기
     */
    public List<CommentDto> getCommentList() {
        List<CommentEntity> commentEntities = commentRepository.findAll();
        List<CommentDto> dtos = new ArrayList<>();

        for (CommentEntity entity : commentEntities) {
            CommentDto dto = CommentDto.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }

    /**
     * 댓글 가져오기
     */
    public CommentDto getComment(Long id) {
        CommentEntity entity = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return CommentDto.builder()
                .idx(entity.getIdx())
                .contents(entity.getContents())
                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }

    /**
     * 댓글 등록
     */
    public CommentEntity create(CommentDto commentDto) {
        CommentEntity entity = CommentEntity.builder()
                .contents(commentDto.getContents())
                .createdAt(LocalDateTime.now())
                .build();
        return commentRepository.save(entity);
    }

    /**
     * 댓글 수정
     */
    public CommentEntity update(CommentDto commentDto) {
        CommentEntity entity = commentRepository.findById(commentDto.getIdx()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setContents(commentDto.getContents());
        return commentRepository.save(entity);
    }

    /**
     * 댓글 삭제
     */
    public void delete(Long id) {
        CommentEntity entity = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        commentRepository.delete(entity);
    }
}