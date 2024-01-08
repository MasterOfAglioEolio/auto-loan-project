package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.dto.JudgmentDto;
import com.verystrong.car_loan_project.service.JudgmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/application/judgments")
public class JudgmentController {

    private final JudgmentService judgmentService;

    @GetMapping()
    public String judgement() {

        log.info("[Judgement]");
        return "application/judgments/judgment";
    }

    @PostMapping("/judgment")
    public String create(@RequestBody JudgmentDto dto) {
        judgmentService.create(dto);
        return "application/judgments/result";
    }

    @GetMapping("/{judgmentId}")
    public String get(@PathVariable Long judgmentId) {
        judgmentService.get(judgmentId);
        return "judgements/";
    }

    @PutMapping("/{judgmentId}")
    public String update(@PathVariable Long judgmentId, @RequestBody JudgmentDto dto) {
        judgmentService.update(judgmentId, dto);
        return "judgements/";
    }

    @DeleteMapping("/{judgmentId}")
    public String delete(@PathVariable Long judgmentId) {
        judgmentService.delete(judgmentId);

        return "judgements/";
    }

    @PatchMapping("/{judgmentId}/grants")
    public String grant(@PathVariable Long judgmentId) {
        judgmentService.grant(judgmentId);
        return "judgements/";
    }


}
