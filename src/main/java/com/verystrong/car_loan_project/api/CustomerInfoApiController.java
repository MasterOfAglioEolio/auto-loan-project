package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CustomerInfoApiController {

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @PostMapping("/api/customerinfo/inforegister")
    public CustomerInfo create(@RequestBody CustomerInfoDto dto)
    {

        CustomerInfo customerInfo = dto.toEntity();
        log.info("[api] create customer"+customerInfo);
        return customerInfoRepository.save(customerInfo);
    }

    @GetMapping("/api/customerinfo/{customerId}")
    public CustomerInfo show(@PathVariable Long customerId)
    {
        log.info("[api] show customerInfo"+customerId);
        return customerInfoRepository.findById(customerId).orElse(null);
    }

}
