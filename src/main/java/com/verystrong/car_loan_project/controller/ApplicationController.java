package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import com.verystrong.car_loan_project.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationService applicationService;

    private final ModelMapper modelMapper;


    @PostMapping("/application/new")
    public String create(ApplicationDto dto){

        applicationService.create(dto);
        return "application/";
    }

    @GetMapping("/application/{applicationId}")
    public String get(@PathVariable Long applicationId, Model model)
    {
        Application application = applicationService.get(applicationId);
        //2. 모델에 데이터 등록하기
        // application라는 이름으로 application 객체를 모델에 등록합니다.
        // 이를 통해 application라는 이름으로 application 객체를 ""뷰""로 전달할 수 있게 됩니다.
        model.addAttribute("application", application);
        log.info("[Model]:"+model.addAttribute("application", application));

        //3. 뷰 페이지 반환하기
        return "application/show";

    }
    @GetMapping("application/{applicationId}/edit")  // TODO: URI에 행위에 대한 동사 표현이 들어가면 안된다(CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.)
    public String edit(@PathVariable Long applicationId, Model model)
    {
        Application application = applicationService.get(applicationId);
        //2. 모델에 데이터 등록하기
        model.addAttribute("application", application);
        //3. 뷰페이지 설정하기
        return "application/edit";
    }

    @PostMapping("/application/update")
    public String update(ApplicationDto dto)
    {

        //3. 리퍼지토리로 엔티티를 DB에 저장

        Application saved = applicationService.update(dto);
        return "redirect:/application/"+saved.getApplicationId();
    }

    @GetMapping("/application/{applicationId}/delete")
    public String delete(@PathVariable Long applicationId, RedirectAttributes rttr)
    {
        applicationService.delete(applicationId);
        rttr.addFlashAttribute("msg","삭제되었습니다.");
        //3. 결과 페이지로 리다이렉트
        return "redirect:/application";

    }
}
