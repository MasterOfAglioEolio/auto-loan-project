package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.dto.QuestionDto;
import com.verystrong.car_loan_project.entity.QuestionEntity;
import com.verystrong.car_loan_project.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/question/list")
    public List<QuestionDto> questionList() {
        return questionService.getQuestionList(); }

    @GetMapping("/question/{id}")
    public QuestionDto getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @PostMapping("/question")
    public QuestionEntity create(@RequestBody QuestionDto questionDto) {
        return questionService.create(questionDto);
    }

    @PatchMapping("/question")
    public QuestionEntity update(@RequestBody QuestionDto questionDto) {
        return questionService.update(questionDto);
    }

    @DeleteMapping("/question/{id}")
    public void delete(@PathVariable Long id) {
        questionService.delete(id);
    }
}
