package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findByCustomerInfo_CustomerId(Long customerId);
    Application findByAccountId(String accountId);
}
