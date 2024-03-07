package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    Order findByAccountId(String accountId);
}
