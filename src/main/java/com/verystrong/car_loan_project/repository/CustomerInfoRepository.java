package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.CustomerInfo;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< Updated upstream

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
=======
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerInfoRepository extends
        JpaRepository<CustomerInfo, Long>
//        QuerydslPredicateExecutor<CustomerInfo> // TODO : 검색기능 추가인데 필요할까? 일단 보류
//        QuerydslBinderCustomizer<QCustomerinfo>
{
    
}