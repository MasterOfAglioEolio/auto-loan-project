package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.dto.CommentDto;
import com.verystrong.car_loan_project.entity.CommentEntity;
import com.verystrong.car_loan_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/list")
    public List<CommentDto> commentList() {
        return commentService.getCommentList(); }

    @GetMapping("/comment/{id}")
    public CommentDto getBoard(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @PostMapping("/comment")
    public CommentEntity create(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @PatchMapping("/comment")
    public CommentEntity update(@RequestBody CommentDto commentDto) {
        return commentService.update(commentDto);
    }

    @DeleteMapping("/comment/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}
