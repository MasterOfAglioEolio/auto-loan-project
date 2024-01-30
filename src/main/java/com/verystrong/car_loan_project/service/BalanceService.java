package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Balance;
import com.verystrong.car_loan_project.domain.Repayment;
import com.verystrong.car_loan_project.dto.BalanceDto;

public interface BalanceService {

    Balance create(Long applicationId, BalanceDto dto);

    Balance get(Long applicationId);

    Balance update(Long applicationId, BalanceDto dto);

    Balance repaymentUpdate(Long applicationId, BalanceDto dto);

    void delete(Long applicationId);
}
