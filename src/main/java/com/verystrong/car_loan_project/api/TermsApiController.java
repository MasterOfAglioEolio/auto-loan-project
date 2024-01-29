package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.dto.TermsDto;
import com.verystrong.car_loan_project.service.TermsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/application/terms")
@RequiredArgsConstructor
public class TermsApiController {
//    private final TermsService termsService;
//
//    @GetMapping("/form")
//    public String new_terms(){
//        return "/application/terms/form";
//    }
//    @PostMapping("/form")
//    public String create(TermsDto dto){  // 약관 생성 controller
//        termsService.create(dto);
//        return "redirect:/application/form";
//    }

//    @GetMapping("/")
//    public String getAll()  // 모든 약관 조회
//    {
//        termsService.getAll();
//        return "terms/";
//    }
}
