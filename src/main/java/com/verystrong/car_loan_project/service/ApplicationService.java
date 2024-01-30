package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.AcceptTerms;
import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;

public interface ApplicationService {

    ApplicationDto create(ApplicationDto dto,String accountId);
    ApplicationDto get(String accountId);
    ApplicationDto update(ApplicationDto dto,String accountId);
    void delete(String accountId);
    Boolean acceptTerms(Long applicationId, ApplicationDto.AcceptTerms terms);
//    ApplicationDto contract(Long applicationId);
}
