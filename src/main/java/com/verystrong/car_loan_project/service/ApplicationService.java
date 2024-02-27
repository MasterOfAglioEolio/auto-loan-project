package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.dto.ApplicationDto;


public interface ApplicationService {

    ApplicationDto create(ApplicationDto dto,String accountId);
    ApplicationDto get(String accountId);
    ApplicationDto update(ApplicationDto dto,String accountId);
    void delete(String accountId);
    Boolean acceptTerms(Long applicationId, ApplicationDto.AcceptTerms terms);
//    ApplicationDto contract(Long applicationId);
}
