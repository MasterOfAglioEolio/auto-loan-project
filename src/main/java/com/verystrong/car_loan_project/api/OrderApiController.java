package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Order;
import com.verystrong.car_loan_project.dto.OrderDto;
import com.verystrong.car_loan_project.repository.OrderRepository;
import com.verystrong.car_loan_project.service.JwtService;
import com.verystrong.car_loan_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OrderApiController {

    @Autowired
    JwtService jwtService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/api/orders")
    public ResponseEntity<OrderDto> getOrder(
            @CookieValue(value = "token", required = false) String token
    ) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId = jwtService.getId(token);
        OrderDto orders = orderService.getOrder(accountId);

        return new ResponseEntity<OrderDto>(orders, HttpStatus.OK);
    }

    @PostMapping("/api/orders")
    public ResponseEntity<OrderDto> pushOrder(
            @RequestBody OrderDto orderDto,
            @CookieValue(value="token", required = false) String token){

        if(!jwtService.isValid(token))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId = jwtService.getId(token);
        OrderDto push= orderService.pushOrder(orderDto,accountId);


        return new ResponseEntity<>(push,HttpStatus.OK);

    }

}
