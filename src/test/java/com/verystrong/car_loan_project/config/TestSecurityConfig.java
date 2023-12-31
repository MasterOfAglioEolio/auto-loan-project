package com.verystrong.car_loan_project.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

@Import(SecurityConfig.class)
class TestSecurityConfig {

//    @MockBean
//    private UserAccountService userAccountService;
//
//    @BeforeTestMethod
//    public void securitySetUp() {
//        given(userAccountService.searchUser(anyString()))
//                .willReturn(Optional.of(createUserAccountDto()));
//        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString()))
//                .willReturn(createUserAccountDto());
//    }
//
//
//    private UserAccountDto createUserAccountDto() {
//        return UserAccountDto.of(
//                "unoTest",
//                "pw",
//                "uno-test@email.com",
//                "uno-test",
//                "test memo"
//        );
//    }

}