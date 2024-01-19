package com.verystrong.car_loan_project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.JudgmentDto;
import com.verystrong.car_loan_project.service.ApplicationService;
import com.verystrong.car_loan_project.service.JudgmentService;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/application/judgments")
public class JudgmentController {

    private final JudgmentService judgmentService;


    @PostMapping("/judgment")
    public String judgment(ApplicationDto applicationDto) throws JsonProcessingException {

        JudgmentDto judgment = judgmentService.judgment(applicationDto);
        Long judgmentId = judgment.getJudgmentId();
//      response save해서 전달하기
//        // result를 뷰에 전달
        return "redirect:/application/judgments/judgment/"+judgmentId;
//        return "application/judgments/judgment";

    }

    @GetMapping("/judgment/{judgmentId}")
    public String get(@PathVariable Long judgmentId, Model model) {
        log.info("[Predict data get]");
        JudgmentDto judgmentDto = judgmentService.get(judgmentId);

        model.addAttribute("judgment",judgmentDto);

        return "application/judgments/judgment";
    }

//    @GetMapping("/{judgmentId}")
//    public String get(@PathVariable Long judgmentId) {
//        judgmentService.get(judgmentId);
//        return "application/judgements/";
//    }
//
//    @PutMapping("/{judgmentId}")
//    public String update(@PathVariable Long judgmentId, @RequestBody JudgmentDto dto) {
//        judgmentService.update(judgmentId, dto);
//        return "judgements/";
//    }
//
//    @DeleteMapping("/{judgmentId}")
//    public String delete(@PathVariable Long judgmentId) {
//        judgmentService.delete(judgmentId);
//
//        return "judgements/";
//    }
//
//    @PatchMapping("/{judgmentId}/grants")
//    public String grant(@PathVariable Long judgmentId) {
//        judgmentService.grant(judgmentId);
//        return "judgements/";
//    }


}
