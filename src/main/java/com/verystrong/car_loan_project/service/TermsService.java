package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Terms;
import com.verystrong.car_loan_project.dto.TermsDto;

import java.util.List;

public interface TermsService {

    TermsDto create(TermsDto dto);
    List<Terms> getAll();
}
