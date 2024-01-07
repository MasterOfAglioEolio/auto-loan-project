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
@RequestMapping("/customerinfo")
@Controller
public class CustomerInfoController {


    @Autowired
    private CustomerInfoService customerInfoService;

    @GetMapping
    public String Home()
    {

        return "customerinfo/index";
    }
    @GetMapping("/new")
    public String createCustomerInfoForm()
    {
        log.info("[Register Page]");
        return "customerinfo/inforegister";
    }

    @PostMapping("/new")
    public String create(CustomerInfoDto dto)
    {
        CustomerInfoDto saved = customerInfoService.create(dto);
        Long newCustomerId = saved.toEntity().getCustomerId();

        return "redirect:/customerinfo/"+newCustomerId;

    }

    @GetMapping("/{customerId}")
    public String show(@PathVariable Long customerId, Model model)
    {
        CustomerInfoDto customerInfo = customerInfoService.get(customerId);
        // 모델에 데이터 등록하기
        model.addAttribute("customerInfo", customerInfo);
        log.info("model:"+model.addAttribute("customerInfo", customerInfo));
        //3. 뷰 페이지 반환하기
        return "customerinfo/show";
    }


//    @PutMapping("/{customerId}")  // TODO: URI에 행위에 대한 동사 표현이 들어가면 안된다(CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.)
    @GetMapping("/{customerId}/edit")
    public String edit(@PathVariable Long customerId, Model model)
    {

        CustomerInfoDto customerInfo = customerInfoService.get(customerId);
        //2. 모델에 데이터 등록하기
        model.addAttribute("customerInfo", customerInfo);
        //3. 뷰페이지 설정하기
        return "customerinfo/edit";
    }

    @PostMapping("/update")
    public String update(CustomerInfoDto dto)
    {
        CustomerInfoDto saved = customerInfoService.update(dto);
        Long newCustomerId = saved.toEntity().getCustomerId();

        if (saved !=null){
            return "redirect:/customerinfo/"+newCustomerId;
        }
        return "redirect:/customerinfo";


    }

//    @DeleteMapping("/{customerId}/delete")
    @GetMapping("/{customerId}/delete")
    public String delete(@PathVariable Long customerId, RedirectAttributes rttr)
    {

        customerInfoService.delete(customerId);
        rttr.addFlashAttribute("msg","삭제되었습니다.");
        //3. 결과 페이지로 리다이렉트
        return "redirect:/customerinfo";

    }




}
