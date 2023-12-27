package com.verystrong.car_loan_project.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("View 컨트롤러 - 회원 정보")
@WebMvcTest(CustomerInfoController.class)
class CustomerInfoControllerTest {
    private final MockMvc mvc;

    public CustomerInfoControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }



    @DisplayName("[view] [GET] 회원 정보 입력 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestingCustomerInfoView_thenReturnsCustomerInfoView() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/customerinfo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customerinfo"));
    }

    @DisplayName("[view] [GET] 회원 정보 입력 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestingCustomerIdInfoView_thenReturnsCustomerIdInfoView() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/customerinfo/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customerinfo"));
    }
}