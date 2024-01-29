package com.verystrong.car_loan_project.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.JudgmentDto;
import com.verystrong.car_loan_project.service.JudgmentService;
import com.verystrong.car_loan_project.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class JudgmentApiController {

    @Autowired
    private final JudgmentService judgmentService;
    @Autowired
    private JwtService jwtService;


    @PostMapping("/api/judgment")
    public ResponseEntity<JudgmentDto> judgment(@CookieValue(value = "token", required = false) String token) throws JsonProcessingException {

        String accountId=jwtService.getId(token);
        JudgmentDto judgment = judgmentService.judgment(accountId);
        return new ResponseEntity<>(judgment, HttpStatus.CREATED);
    }

    @GetMapping("/api/judgment/{accountId}")
    public ResponseEntity<JudgmentDto> get(@CookieValue(value = "token", required = false) String token) {
        String accountId=jwtService.getId(token);
        log.info("[Predict data get]");
        JudgmentDto judgment = judgmentService.get(accountId);
        return new ResponseEntity<>(judgment, HttpStatus.OK);
    }

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
