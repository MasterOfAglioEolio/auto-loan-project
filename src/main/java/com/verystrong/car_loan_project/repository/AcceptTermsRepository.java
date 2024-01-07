package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.AcceptTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptTermsRepository extends JpaRepository<AcceptTerms, Long> {

}
