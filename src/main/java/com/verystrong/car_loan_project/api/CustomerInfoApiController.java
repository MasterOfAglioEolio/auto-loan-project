package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import com.verystrong.car_loan_project.service.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CustomerInfoApiController {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Autowired
    private CustomerInfoService customerInfoService;

    @PostMapping("/api/customerinfo/inforegister")
    public CustomerInfo create(@RequestBody CustomerInfoDto dto)
    {

        return customerInfoService.create(dto);
    }

    @GetMapping("/api/customerinfo/{customerId}")
    public CustomerInfo show(@PathVariable Long customerId)
    {
        log.info("[api] show customerInfo"+customerId);
        return customerInfoRepository.findById(customerId).orElse(null);
    }

    @PatchMapping("/api/customerinfo/{customerId}")
    public ResponseEntity<Object> update(@PathVariable Long customerId, @RequestBody CustomerInfoDto dto)
    {

        //1.DTO->엔티티 변환하기
        // 2. id 찾기
        CustomerInfo saved = customerInfoService.update(dto);
        CustomerInfo target = customerInfoService.get(customerId);
        // 3. 잘못된 요청 처리하기
        if (target == null || (customerId != target.getCustomerId())){
            log.info("잘못된 요청 id {} customerInfo{} ", customerId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //4. 업데이트 및 정상 응답(200)하기
        target.equals(saved);
        log.info("update OK {}", ResponseEntity.status(HttpStatus.OK).body(saved));
        return ResponseEntity.status(HttpStatus.OK).body(saved);

    }

    @DeleteMapping("/api/customerinfo/{customerId}")
    public ResponseEntity<CustomerInfo> delete(@PathVariable Long customerId) {
        //1. 대상 찾기
        CustomerInfo target = customerInfoService.get(customerId);
        //2. 잘못된 요청 처리하기
        if(target == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        //대상 삭제
        customerInfoService.delete(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

}
