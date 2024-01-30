package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import com.verystrong.car_loan_project.service.CustomerInfoService;
import com.verystrong.car_loan_project.service.CustomerInfoServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CustomerInfo 테스트")
@Transactional // 트랜잭션을 Rollback 상태로 묶음
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerInfoApiControllerTest {

    @InjectMocks
    CustomerInfoServiceImpl customerInfoService;

    @Mock
    private CustomerInfoRepository customerInfoRepository;

    @Spy
    private ModelMapper modelMapper;

    private final MockMvc mvc;

    CustomerInfoApiControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view] [GET] 회원 정보 입력 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestingCustomerInfoView_thenReturnsCustomerInfoView() throws Exception {

            mvc.perform(MockMvcRequestBuilders.get("/customerinfo"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.view().name("customerinfo/index"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("customerinfo"));

        }

        @DisplayName("[view] [GET] 회원 정보 조회 - 정상호출")
        @Test
        public void givenNothing_whenRequestingCustomerIdInfoView_thenReturnsCustomerIdInfoView() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/customerinfo/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("customerinfo"));
        }
    }

