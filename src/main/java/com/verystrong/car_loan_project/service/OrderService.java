package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.dto.OrderDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    OrderDto getOrder(String accountId);
    OrderDto pushOrder(OrderDto orderDto, String accountId);

}
