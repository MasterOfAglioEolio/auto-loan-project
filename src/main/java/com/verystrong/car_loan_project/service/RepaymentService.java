package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Repayment;
import com.verystrong.car_loan_project.dto.RepaymentDto;

import java.util.List;

public interface RepaymentService {

    Repayment create(Long applicationId, RepaymentDto dto);

    List<Repayment> get(Long applicationId);

    Repayment update(Long repaymentId, RepaymentDto dto);

    void delete(Long repaymentId);
}
