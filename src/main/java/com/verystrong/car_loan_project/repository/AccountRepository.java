package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.AcceptTerms;
import com.verystrong.car_loan_project.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
