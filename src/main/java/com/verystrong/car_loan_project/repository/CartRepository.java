package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

    List<Cart> findByAccountId(String accountId);
    Cart findByAccountIdAndItemId(String accountId, Long itemId);

    void deleteByAccountId(String accountId);
}
