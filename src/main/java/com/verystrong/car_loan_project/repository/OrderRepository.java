package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findByAccountIdOrderByIdDesc(String accountId);
}
