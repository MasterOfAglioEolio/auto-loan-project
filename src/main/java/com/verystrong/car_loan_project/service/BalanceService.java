package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Balance;
import com.verystrong.car_loan_project.domain.Repayment;
import com.verystrong.car_loan_project.dto.BalanceDto;

public interface BalanceService {

    BalanceDto create(Long applicationId, BalanceDto dto,String accountId);

    BalanceDto get(Long applicationId,String accountId);

    BalanceDto update(Long applicationId, BalanceDto dto);

    BalanceDto repaymentUpdate(Long applicationId, BalanceDto dto);

    void delete(Long applicationId);
}
