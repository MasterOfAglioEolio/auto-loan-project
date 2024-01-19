package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.dto.AccountDto;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;

public interface AccountService {

    AccountDto create(AccountDto dto);
    AccountDto get(Long accountId);
    AccountDto update(AccountDto dto);

    void delete(Long accountId);
}
