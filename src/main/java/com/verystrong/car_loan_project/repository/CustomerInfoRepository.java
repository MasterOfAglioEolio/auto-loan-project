package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.CustomerInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CustomerInfoRepository extends
        JpaRepository<CustomerInfo, Long> {
    
}