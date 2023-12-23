package com.verystrong.car_loan_project.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@DisplayName("Data Rest 테스트")
@Transactional // 트랜잭션을 Rollback 상태로 묶음
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("[api] 사용자 정보 입력 페이지")
    @Test
    void givenNothing_whenRequestingCustomerInfoPage_thenReturnCustomerInfoPage() throws Exception {
        //Given

        //When
        mvc.perform(MockMvcRequestBuilders.get("/api/customerInfoes")) // TODO : 왜 Infoes로 잡히는지 모르겠음
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")))
                .andDo(print());

        //Then
    }

}
