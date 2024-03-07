package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Repayment;
import com.verystrong.car_loan_project.dto.RepaymentDto;

import java.util.List;

public interface RepaymentService {

    RepaymentDto create(Long applicationId, RepaymentDto dto,String accountId);

    RepaymentDto get(Long applicationId);
    List<RepaymentDto> get_list(Long applicationId);

    RepaymentDto update(Long repaymentId, RepaymentDto dto);

    void delete(Long repaymentId);
}
