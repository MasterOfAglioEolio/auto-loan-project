package com.verystrong.car_loan_project;

import com.verystrong.car_loan_project.config.JpaConfig;
import com.verystrong.car_loan_project.domain.*;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final CustomerInfoRepository customerInfoRepository;
    //private CustomerLoan 어쩌구 대출 데이터 추가시 ;
    JpaRepositoryTest(@Autowired CustomerInfoRepository customerInfoRepository) {
        this.customerInfoRepository = customerInfoRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //Given


        //When
        List<CustomerInfo> customerInfos = customerInfoRepository.findAll();

        //Then
        assertThat(customerInfos)
                .isNotNull()
                .hasSize(0);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        //Given
        long previousCount=customerInfoRepository.count();
        CustomerInfo customerInfo = CustomerInfo.of("new name",
                Gender.MALE,
                21,
                Education.E,
                MartialStatus.E,
                5,
                3,
                IncomeType.a,
                IncomeClass.b,
                Occupation.a,
                OrgType.A,
                11,
                true,
                DwellingType.A,
                HosingType.B,
                ResidenceClass.A,
                12,
                true);

        //When
        CustomerInfo SavedCustomerInfos = customerInfoRepository.save(customerInfo);

        //Then
        assertThat(customerInfoRepository.count()).isEqualTo(previousCount+1);
    }

    @Disabled //TODO : DB 원본 추가후 다시 테스트
    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //Given
        CustomerInfo customerInfo = customerInfoRepository.findById(1L).orElseThrow();
        Gender UpdateGender = Gender.MALE;
        customerInfo.setGender(UpdateGender);


        //When
        CustomerInfo SavedCustomerInfos = customerInfoRepository.save(customerInfo);

        System.out.println(SavedCustomerInfos);
        //Then
        assertThat(SavedCustomerInfos).hasFieldOrPropertyWithValue("gender", UpdateGender);
    }

    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        //Given
        CustomerInfo customerInfo = customerInfoRepository.findById(1L).orElseThrow();
        long previousCustomerCount = customerInfoRepository.count();

        //When
        customerInfoRepository.delete(customerInfo);

        //Then
        assertThat(customerInfoRepository.count()).isEqualTo(previousCustomerCount-1);
    }


}
