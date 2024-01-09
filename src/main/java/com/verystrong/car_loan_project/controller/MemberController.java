package com.verystrong.car_loan_project.controller;

import ch.qos.logback.classic.Logger;
import com.verystrong.car_loan_project.dto.ArticleForm;
import com.verystrong.car_loan_project.dto.MemberForm;
import com.verystrong.car_loan_project.entity.Article;
import com.verystrong.car_loan_project.entity.Member;
import com.verystrong.car_loan_project.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/signup")
    public String newMemberForm(){
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createMember(MemberForm form){
        log.info(form.toString());
        // 1.DTO를 엔티티로 변환
        Member member=form.toEntity();
        log.info(member.toString());
        //2. 리파지터리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "redirect:/members/"+saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " +id);
        //1. id를 조회해 데이터 가져오기
        Member memberEntity =memberRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("member", memberEntity);
        //3. 뷰 페이지 반환하기
        return "members/show";
    }
    @GetMapping("/members")
    public String index(Model model) {
        //1. 모든 데이터 가져오기
        ArrayList<Member> memberEntityList = (ArrayList<Member>) memberRepository.findAll();
        //2. 모델에 데이터 등록하기
        model.addAttribute("memberList", memberEntityList);
        //3. 뷰 페이지 설정하기
        return "members/index";
    }
}
