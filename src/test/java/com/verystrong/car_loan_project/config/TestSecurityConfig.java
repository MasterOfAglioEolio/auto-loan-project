package com.verystrong.car_loan_project.config;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.dto.AccountDto;
import com.verystrong.car_loan_project.repository.AccountRepository;
import com.verystrong.car_loan_project.service.AccountService;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static com.verystrong.car_loan_project.domain.Account_type.AccountRole.USER;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
class TestSecurityConfig {

//    @MockBean
//    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @BeforeTestMethod
    public void securitySetUp() {
        given(accountRepository.findById(anyString()))
                .willReturn(Optional.of(Account.of(
                        "unoTest",
                        "password",
                        "asd@email.com",
                        USER
                )));

    }


    private AccountDto createUserAccountDto() {
        return AccountDto.of(
                "unoTest",
                "pw",
                "uno-test@email.com",
                USER
        );
    }

}