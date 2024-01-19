package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);
}
