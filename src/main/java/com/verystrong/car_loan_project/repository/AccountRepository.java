package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByEmail(String email);
    Account findByAccountIdAndPassword(String accountId,String password);

}
