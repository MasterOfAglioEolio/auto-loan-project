package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;

public interface ApplicationService {

    Application create(ApplicationDto dto);
    Application get(Long applicationId);
    Application update(ApplicationDto dto);

    void delete(Long applicationId);
}
