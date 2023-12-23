package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
}