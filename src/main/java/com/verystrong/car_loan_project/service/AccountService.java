package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.dto.AccountDto;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;

public interface AccountService {

    AccountDto create(AccountDto dto) throws IllegalAccessException;
    void validateDuplicateAccount(Account account) throws IllegalAccessException;

    AccountDto get(String accountId);

    AccountDto update(AccountDto dto);


    void delete(String accountId);
}
