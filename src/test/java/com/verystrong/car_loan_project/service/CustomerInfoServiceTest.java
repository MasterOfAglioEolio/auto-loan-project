package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class CustomerInfoServiceTest {

    @InjectMocks private CustomerInfoService sut; //sut : system under test
    @Mock
    private CustomerInfoRepository customerInfoRepository;

    /*
       회원 정보 입력->회원 정보 등록
       DB 전달
       홈 버튼*/

    @DisplayName("회원 정보를 입력하면, 회원 정보를 등록한다.")
    @Test
    void givenCustomerInfo_whenSavingCustomerInfo_thenSavesCustomerInfo()
    {

        //Given
        CustomerInfoDto dto = CustomerInfoDto.of(Gender.Woman,
                21.2F,
                Education.College,
                MaritalStatus.Bereaved,
                2,
                1,
                IncomeType.Business,
                IncomeClass.A,
                Occupation.accounting,
                OrgType.Bank_insurance,
                2.1F,
                HouseOwnedYN.Y,
                DwellingType.Charter,
                HousingType.Apartment,
                ResidenceClass.Best,
                1.2F,
                CarOwnedYN.Y
                );
        given(customerInfoRepository.save(any(CustomerInfo.class))).willReturn(null);
        //When
        sut.saveCustomerInfo(dto);
        //Then
        then(customerInfoRepository).should().save(any(CustomerInfo.class));
    }

    @DisplayName("회원 정보 수정 버튼을 누르면 회원 정보를 수정한다.")
    @Test
    void givenCustomerModifiedInfo_whenUpdatingCustomerInfo_thenUpdatesCustomerInfo()
    {

        //Given
        CustomerInfoDto dto = CustomerInfoDto.of(Gender.Woman,
                21.2F,
                Education.College,
                MaritalStatus.Bereaved,
                2,
                1,
                IncomeType.Business,
                IncomeClass.A,
                Occupation.accounting,
                OrgType.Bank_insurance,
                2.1F,
                HouseOwnedYN.Y,
                DwellingType.Charter,
                HousingType.Apartment,
                ResidenceClass.Best,
                1.2F,
                CarOwnedYN.Y
        );
        given(customerInfoRepository.save(any(CustomerInfo.class))).willReturn(null);
        //When
        sut.updateCustomerInfo(dto);
        //Then
        then(customerInfoRepository).should().save(any(CustomerInfo.class));
    }

    @DisplayName("회원 정보 삭제 버튼을 누르면 회원 정보를 삭제한다.")
    @Test
    void givenDeleteButton_whenDeletingCustomerInfo_thenDeletesCustomerInfo()
    {

        //Given
        CustomerInfoDto dto = CustomerInfoDto.of(Gender.Woman,
                21.2F,
                Education.College,
                MaritalStatus.Bereaved,
                2,
                1,
                IncomeType.Business,
                IncomeClass.A,
                Occupation.accounting,
                OrgType.Bank_insurance,
                2.1F,
                HouseOwnedYN.Y,
                DwellingType.Charter,
                HousingType.Apartment,
                ResidenceClass.Best,
                1.2F,
                CarOwnedYN.Y
        );
        willDoNothing().given(customerInfoRepository).delete(any(CustomerInfo.class));
        //When
        sut.deleteCustomerInfo(dto); // TODO : 입력조건 생각
        //Then
        then(customerInfoRepository).should().delete(any(CustomerInfo.class));
    }



}