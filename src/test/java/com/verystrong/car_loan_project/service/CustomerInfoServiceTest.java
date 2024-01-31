package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.repository.AccountRepository;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class CustomerInfoServiceTest {

    @InjectMocks private CustomerInfoServiceImpl sut; //sut : system under test
    @Mock
    private CustomerInfoRepository customerInfoRepository;
    @Mock
    private AccountRepository accountRepository; // Mock the account repository
    @Mock
    private ModelMapper modelMapper; // Mock the model mapper

    /*
       회원 정보 입력->회원 정보 등록
       DB 전달
       홈 버튼*/

    @BeforeEach
    void setUp() {
        CustomerInfo customerInfo = new CustomerInfo();

        given(accountRepository.findById(anyString())).willReturn(Optional.of(new Account())); // Return a new Account when findById is called
        given(modelMapper.map(any(), eq(CustomerInfo.class))).willAnswer(invocation -> new CustomerInfo());
        given(modelMapper.map(any(), eq(CustomerInfoDto.class))).willAnswer(invocation -> new CustomerInfoDto());
        given(customerInfoRepository.findByAccountId(anyString())).willReturn(customerInfo); // Return the customerInfo when findById is called
        given(customerInfoRepository.save(any(CustomerInfo.class))).willReturn(customerInfo); // Return the customerInfo when save is called
    }

    @DisplayName("회원 정보를 입력하면, 회원 정보를 등록한다.")
    @Test
    void givenCustomerInfo_whenSavingCustomerInfo_thenSavesCustomerInfo()
    {
        //Given
        String accountId = "testAccountId";
        CustomerInfoDto dto = CustomerInfoDto.builder()
                .gender(Gender.Woman)
                .age(21.2F)
                .education(Education.College)
                .maritalStatus(MaritalStatus.Bereaved)
                .familyCount(2)
                .childCount(1)
                .incomeType(IncomeType.Business)
                .incomeClass(IncomeClass.A)
                .occupation(Occupation.accounting)
                .orgType(OrgType.Bank_insurance)
                .employedYears(2.1F)
                .houseOwnedYN(HouseOwnedYN.Y)
                .dwellingType(DwellingType.Charter)
                .housingType(HousingType.Apartment)
                .residenceClass(ResidenceClass.Best)
                .carOwnedYN(CarOwnedYN.Y)
                .build();
        given(customerInfoRepository.save(any(CustomerInfo.class))).willReturn(null);
        //When
        sut.create(dto, accountId);
        //Then
        then(customerInfoRepository).should().save(any(CustomerInfo.class));
    }
    @DisplayName("회원 ID를 입력하면 회원 정보를 가져온다.")
    @Test
    void givenAccountId_whenGettingCustomerInfo_thenGetCustomerInfo()
    {
        String accountId = "testAccountId";
        CustomerInfo customerInfo = CustomerInfo.builder()
                .accountId(accountId)
                .build();

        when(customerInfoRepository.findByAccountId(accountId)).thenReturn(customerInfo);
        CustomerInfoDto actual = sut.get("testAccountId");
        assertThat(actual.getAccountId()).isSameAs(accountId);


    }

    @DisplayName("회원 정보 수정 버튼을 누르면 회원 정보를 수정한다.")
    @Test
    void givenCustomerModifiedInfo_whenUpdatingCustomerInfo_thenUpdatesCustomerInfo()
    {
        //Given
        String accountId = "testAccountId";
        CustomerInfoDto dto = CustomerInfoDto.builder()
                .gender(Gender.Woman)
                .age(21.2F)
                .education(Education.College)
                .maritalStatus(MaritalStatus.Bereaved)
                .familyCount(2)
                .childCount(1)
                .incomeType(IncomeType.Business)
                .incomeClass(IncomeClass.A)
                .occupation(Occupation.accounting)
                .orgType(OrgType.Bank_insurance)
                .employedYears(2.1F)
                .houseOwnedYN(HouseOwnedYN.Y)
                .dwellingType(DwellingType.Charter)
                .housingType(HousingType.Apartment)
                .residenceClass(ResidenceClass.Best)
                .carOwnedYN(CarOwnedYN.Y)
                .build();
        given(customerInfoRepository.save(any(CustomerInfo.class))).willReturn(null);
        //When
        sut.update(dto, accountId);
        //Then
        then(customerInfoRepository).should().save(any(CustomerInfo.class));
    }

    @DisplayName("회원 정보 삭제 버튼을 누르면 회원 정보를 삭제한다.")
    @Test
    void givenDeleteButton_whenDeletingCustomerInfo_thenDeletesCustomerInfo()
    {
        //Given
        String accountId = "testAccountId";
        willDoNothing().given(customerInfoRepository).delete(any(CustomerInfo.class));
        //When
        sut.delete(accountId);
        //Then
        then(customerInfoRepository).should().delete(any(CustomerInfo.class));
    }
}
