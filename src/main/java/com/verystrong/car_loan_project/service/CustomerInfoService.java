package com.verystrong.car_loan_project.service;


import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Transactional
@Service
public class CustomerInfoService {

    private final CustomerInfoRepository customerInfoRepository;

    public void saveCustomerInfo(CustomerInfoDto dto) {
    }

    public void updateCustomerInfo(CustomerInfoDto dto) {
    }

    public void deleteCustomerInfo(CustomerInfoDto dto) {
    }

//    @Transactional
//    public List<CustomerInfoDto> saveCustomerInfo(){
//    }
}
