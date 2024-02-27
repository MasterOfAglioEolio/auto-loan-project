package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Order;
import com.verystrong.car_loan_project.dto.OrderDto;
import com.verystrong.car_loan_project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    OrderRepository orderRepository;

    private final ModelMapper modelMapper;


    @Override
    public OrderDto getOrder(String accountId) {
        List<Order> orders = orderRepository.findByAccountIdOrderByIdDesc(accountId);
        return modelMapper.map(orders,OrderDto.class);
    }

    @Override
    public OrderDto pushOrder(OrderDto orderDto, String accountId) {
        Order newOrder = new Order();

        newOrder.setAccountId(accountId);
        newOrder.setName(orderDto.getName());
        newOrder.setAddress(orderDto.getAddress());
        newOrder.setPayment(orderDto.getPayment());
        newOrder.setCardNumber(orderDto.getCardNumber());
        newOrder.setItems(orderDto.getItems());

        orderRepository.save(newOrder);

        return modelMapper.map(newOrder,OrderDto.class);
    }
}
