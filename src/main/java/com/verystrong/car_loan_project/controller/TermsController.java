package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.domain.Terms;
import com.verystrong.car_loan_project.dto.TermsDto;
import com.verystrong.car_loan_project.service.TermsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TermsController {
    private final TermsService termsService;

    @PostMapping("/terms/new")
    public String create(@RequestBody TermsDto dto){  // 약관 생성 controller
        termsService.create(dto);
        return "terms/";
    }

//    @GetMapping("/")
//    public String getAll()  // 모든 약관 조회
//    {
//        termsService.getAll();
//        return "terms/";
//    }
}
