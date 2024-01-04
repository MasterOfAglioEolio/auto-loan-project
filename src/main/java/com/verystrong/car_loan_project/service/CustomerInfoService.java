package com.verystrong.car_loan_project.service;


import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;


public interface CustomerInfoService {

    CustomerInfo create(CustomerInfoDto dto);
    CustomerInfo get(Long customerId);
    CustomerInfo update(CustomerInfoDto dto);

    void delete(Long customerId);



}
