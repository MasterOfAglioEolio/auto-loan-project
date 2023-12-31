package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.CustomerInfo;

import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RepositoryRestResource
public interface CustomerInfoRepository extends
        JpaRepository<CustomerInfo, Long> {


    
}