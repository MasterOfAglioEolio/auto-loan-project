package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.domain.Account_type.AccountRole;


public record AccountDto(String accountId, String password, String email, AccountRole role) {
//    private String userId;
//
//    private String password;
//
//    private String userName;
//
//    private String email;


    public static AccountDto of(String accountId, String password,String email,AccountRole role) {
       return new AccountDto(accountId, password, email,role);
    }

    public static AccountDto from(Account entity){
        return new AccountDto(
                entity.getAccountId(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getRole()
        );
    }
}
