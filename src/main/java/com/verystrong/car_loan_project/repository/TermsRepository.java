package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Terms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<Terms, Long> {

}
