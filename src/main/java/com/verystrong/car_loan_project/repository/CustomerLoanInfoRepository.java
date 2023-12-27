package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.domain.CustomerLoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerLoanInfoRepository extends JpaRepository<CustomerLoanInfo, Long> {
}
