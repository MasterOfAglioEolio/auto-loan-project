package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Order;
import com.verystrong.car_loan_project.dto.OrderDto;
import com.verystrong.car_loan_project.repository.CartRepository;
import com.verystrong.car_loan_project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final CartRepository cartRepository;

    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;


    @Override
    public OrderDto getOrder(String accountId) {
        Order order = orderRepository.findByAccountId(accountId);
        log.info("[GetOrder in Service] {} ",order);
        return modelMapper.map(order,OrderDto.class);
    }

    @Override
    public OrderDto pushOrder(OrderDto orderDto, String accountId) {
        Order order = modelMapper.map(orderDto, Order.class);
        order.setAccountId(accountId);
        order.setMaturity(LocalDateTime.now().plusMonths(order.getLoanTerm()));
        BigDecimal deposit_decimal = new BigDecimal(order.getDeposit());
        order.setApprovalAmount(order.getCarPrice().subtract(
                order.getCarPrice().divide(deposit_decimal, 2, RoundingMode.HALF_UP)));
        order.setAppliedAt(LocalDateTime.now());
        order.setContractedAt(LocalDateTime.now()); // 일단은 신청 시간으로 계약 체결 !

        log.info("[Check Order]"+order);

        orderRepository.save(order);
//        cartRepository.deleteByAccountId(accountId);

        return modelMapper.map(order,OrderDto.class);
    }
}
