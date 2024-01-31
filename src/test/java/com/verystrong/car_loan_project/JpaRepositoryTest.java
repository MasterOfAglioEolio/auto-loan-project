package com.verystrong.car_loan_project;

import com.verystrong.car_loan_project.config.JpaConfig;
import com.verystrong.car_loan_project.domain.*;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.*;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.DwellingType;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.Education;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.Gender;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.IncomeClass;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.IncomeType;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.Occupation;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.OrgType;
import com.verystrong.car_loan_project.domain.CustomerInfo_type.ResidenceClass;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaRepositoryTest.TestJpaConfig.class)
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
        CustomerInfo customerInfo = CustomerInfo.builder()
                .accountId("newId")
                .gender(Gender.Man)
                .age(21)
                .education(Education.University)
                .maritalStatus(MaritalStatus.Single)
                .familyCount(5)
                .childCount(3)
                .incomeType(IncomeType.Other)
                .incomeClass(IncomeClass.F)
                .occupation(Occupation.General_work)
                .orgType(OrgType.Communications)
                .employedYears(11)
                .houseOwnedYN(HouseOwnedYN.N)
                .dwellingType(DwellingType.Family_joint)
                .housingType(HousingType.Detached_house)
                .residenceClass(ResidenceClass.Best)
                .carOwnedYN(CarOwnedYN.Y)
                .build();

        //When
        CustomerInfo SavedCustomerInfos = customerInfoRepository.save(customerInfo);

        //Then
        assertThat(customerInfoRepository.count()).isEqualTo(previousCount+1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //Given
        CustomerInfo customerInfo = customerInfoRepository.findById(1L).orElseThrow();
        Gender UpdateGender = Gender.Woman;
        customerInfo.setGender(UpdateGender);

        //When
        CustomerInfo SavedCustomerInfos = customerInfoRepository.save(customerInfo);

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

    @EnableJpaAuditing
    @TestConfiguration
    public static class TestJpaConfig {
        @Bean
        public AuditorAware<String> auditorAware() {
            return () -> Optional.of("uno");
        }
    }



}
