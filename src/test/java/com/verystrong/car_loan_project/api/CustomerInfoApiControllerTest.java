package com.verystrong.car_loan_project.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import com.verystrong.car_loan_project.service.CustomerInfoService;
import com.verystrong.car_loan_project.service.CustomerInfoServiceImpl;
import com.verystrong.car_loan_project.service.JwtService;
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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("CustomerInfo 테스트")
@Transactional // 트랜잭션을 Rollback 상태로 묶음
@SpringBootTest
@WebMvcTest(CustomerInfoApiController.class)
@ExtendWith(MockitoExtension.class)
class CustomerInfoApiControllerTest {

    @InjectMocks
    CustomerInfoServiceImpl customerInfoService;

    @MockBean
    private JwtService jwtService;
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

            mvc.perform(get("/api/info"))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.view().name("/api/info"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("info"));

        }

    @DisplayName("[view] [GET] 회원 정보 조회 - 정상호출")
    @Test
    public void givenNothing_whenRequestingCustomerIdInfoView_thenReturnsCustomerIdInfoView() throws Exception {
        mvc.perform(get("/api/info/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.model().attributeExists("/api/info"));
    }

    @Test
    public void testGetItems() throws Exception {
        // When
        mvc.perform(get("/api/info"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreate() throws Exception {
        // Given
        CustomerInfoDto dto = new CustomerInfoDto();
        dto.setAccountId("123");
        when(jwtService.isValid(any())).thenReturn(true);
        when(jwtService.getId(any())).thenReturn("123");
        when(customerInfoService.create(any(), any())).thenReturn(dto);

        // When & Then
        mvc.perform(post("/api/info/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.accountId", is("123")));
    }

    @Test
    public void testGet() throws Exception {
        // Given
        CustomerInfoDto dto = new CustomerInfoDto();
        dto.setAccountId("123");
        when(jwtService.getId(any())).thenReturn("123");
        when(customerInfoService.get(any())).thenReturn(dto);

        // When & Then
        mvc.perform(get("/api/info/123"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.accountId", is("123")));
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        CustomerInfoDto dto = new CustomerInfoDto();
        dto.setAccountId("123");
        when(jwtService.isValid(any())).thenReturn(true);
        when(jwtService.getId(any())).thenReturn("123");
        when(customerInfoService.update(any(), any())).thenReturn(dto);

        // When & Then
        mvc.perform(put("/api/info/123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.accountId", is("123")));
    }

    @Test
    public void testDelete() throws Exception {
        // Given
        when(jwtService.getId(any())).thenReturn("123");
        doNothing().when(customerInfoService).delete(any());

        // When & Then
        mvc.perform(delete("/api/info/123"))
                .andExpect(status().isNoContent());
    }
    }

