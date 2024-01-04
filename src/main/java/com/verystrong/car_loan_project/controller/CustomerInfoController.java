package com.verystrong.car_loan_project.controller;


import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
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
    private CustomerInfoRepository customerInfoRepository;


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
        log.info("[Register customerInfo] Request :: {}",dto);
        //1. DTO를 엔티티로 변환
        CustomerInfo customerInfo = dto.toEntity();
        log.info("customerInfo to DTO {}",customerInfo.toString());

        //2. 리퍼지토리로 엔티티를 DB에 저장
        CustomerInfo saved = customerInfoRepository.save(customerInfo);
        log.info("DTO to Repository {}",saved.toString());

        return "redirect:/customerinfo/"+saved.getCustomerId();

    }

    @GetMapping("customerinfo/{customerId}")
    public String show(@PathVariable Long customerId, Model model)
    {
        log.info("show customer id = "+customerId);
        //1. id를 조회해 데이터 가져오기
        CustomerInfo customerInfo = customerInfoRepository.findById(customerId).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("customerInfo", customerInfo);
        log.info("model:"+model.addAttribute("customerInfo", customerInfo));
        //3. 뷰 페이지 반환하기
        return "customerinfo/show";
    }

    @GetMapping("customerinfo/{customerId}/edit")
    public String edit(@PathVariable Long customerId, Model model)
    {
        log.info("edit customer id = "+customerId);
        //1. id를 조회해 데이터 가져오기
        CustomerInfo customerInfo = customerInfoRepository.findById(customerId).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("customerInfo", customerInfo);
        //3. 뷰페이지 설정하기
        return "customerinfo/edit";
    }

    @PostMapping("/customerinfo/update")
    public String update(CustomerInfoDto dto)
    {
        log.info("update form to String"+dto.toString());
        //1. DTO를 엔티티로 변환
        CustomerInfo customerInfo = dto.toEntity();
        log.info("customerInfo to DTO {}",customerInfo.toString());
        //2. id 찾기
        CustomerInfo target = customerInfoRepository.findById(customerInfo.getCustomerId()).orElse(null);
        //3. 리퍼지토리로 엔티티를 DB에 저장
        if (target!=null) {
            CustomerInfo saved =customerInfoRepository.save(customerInfo);
            log.info("DTO to Repository {}",saved.toString());
            //4. 수정 결과 페이지로 리다이렉트
            return "redirect:/customerinfo/"+saved.getCustomerId();
        }
        return "redirect:/customerinfo/";

    }

    @GetMapping("/customerinfo/{customerId}/delete")
    public String delete(@PathVariable Long customerId, RedirectAttributes rttr)
    {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1.삭제할 대상 가져오기
        CustomerInfo target = customerInfoRepository.findById(customerId).orElse(null);
        log.info("target"+target.toString());
        // 2. 대상 엔티티 삭제하기
        if (target != null){
            customerInfoRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제되었습니다.");
        }
        //3. 결과 페이지로 리다이렉트
        return "redirect:/customerinfo";

    }


    //    @PostMapping("/customerinfo/new")
//    public String createCustomerInfo(CustomerInfoDto customerInfoDto)
//    {
//        Long customerId= customerInfoService.join(customerInfoDto);
//        LOGGER.info("[Register customerInfo] Response :: ID = {}, age= {} child_count={}," +
//                        " employed_years={}, family_count={}, house_age={}, car_ownedyn={}, dwelling_type={}," +
//                        " education={}, gender={}, house_ownedyn={}, housing_type={}, income_class={}," +
//                        " income_type={}, marital_status={}, occupation={}, org_type={}, residence_class={}",
//                customerId,customerInfoDto.getAge(),customerInfoDto.getChildCount(),customerInfoDto.getEmployedYears(),
//                customerInfoDto.getFamilyCount(), customerInfoDto.getHouseAge(), customerInfoDto.getCarOwnedYN(),
//                customerInfoDto.getDwellingType(), customerInfoDto.getEducation(), customerInfoDto.getGender(),
//                customerInfoDto.getHouseOwnedYN(), customerInfoDto.getHousingType(),customerInfoDto.getIncomeClass(),
//                customerInfoDto.getIncomeType(),customerInfoDto.getMaritalStatus(), customerInfoDto.getOccupation(),
//                customerInfoDto.getOrgType(),customerInfoDto.getResidenceClass());
//        return "/customerinfo/index"; // 나중에 내 정보 화면으로 넘기기
//    }


}
