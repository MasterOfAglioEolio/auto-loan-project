package com.verystrong.car_loan_project.controller;


import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.service.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
//@RequestMapping("/customerinfo")
@Controller
public class CustomerInfoController {


    @Autowired
    private CustomerInfoService customerInfoService;

    @GetMapping
    public String Home()
    {

        return "customerinfo/index";
    }
    @GetMapping("/customerinfo/new")
    public String createCustomerInfoForm()
    {
        log.info("[Register Page]");
        return "customerinfo/inforegister";
    }

    @PostMapping("/customerinfo/new")
    public String create(CustomerInfoDto dto)
    {
        CustomerInfo saved = customerInfoService.create(dto);

        return "redirect:/customerinfo/"+saved.getCustomerId();

    }

    @GetMapping("customerinfo/{customerId}")
    public String show(@PathVariable Long customerId, Model model)
    {
        CustomerInfo customerInfo = customerInfoService.get(customerId);
        // 모델에 데이터 등록하기
        model.addAttribute("customerInfo", customerInfo);
        log.info("model:"+model.addAttribute("customerInfo", customerInfo));
        //3. 뷰 페이지 반환하기
        return "customerinfo/show";
    }

    @GetMapping("customerinfo/{customerId}/edit")  // TODO: URI에 행위에 대한 동사 표현이 들어가면 안된다(CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.)
    public String edit(@PathVariable Long customerId, Model model)
    {

        CustomerInfo customerInfo = customerInfoService.get(customerId);
        //2. 모델에 데이터 등록하기
        model.addAttribute("customerInfo", customerInfo);
        //3. 뷰페이지 설정하기
        return "customerinfo/edit";
    }

    @PostMapping("/customerinfo/update")
    public String update(CustomerInfoDto dto)
    {
        CustomerInfo saved = customerInfoService.update(dto);

        if (saved !=null){
            return "redirect:/customerinfo/"+saved.getCustomerId();
        }
        return "redirect:/customerinfo/";


    }

    @GetMapping("/customerinfo/{customerId}/delete")
    public String delete(@PathVariable Long customerId, RedirectAttributes rttr)
    {

        customerInfoService.delete(customerId);
        rttr.addFlashAttribute("msg","삭제되었습니다.");
        //3. 결과 페이지로 리다이렉트
        return "redirect:/customerinfo";

    }




}
