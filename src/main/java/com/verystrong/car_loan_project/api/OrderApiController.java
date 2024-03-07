package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Order;
import com.verystrong.car_loan_project.dto.*;
import com.verystrong.car_loan_project.repository.OrderRepository;
import com.verystrong.car_loan_project.service.EntryService;
import com.verystrong.car_loan_project.service.JwtService;
import com.verystrong.car_loan_project.service.OrderService;
import com.verystrong.car_loan_project.service.RepaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@RestController
public class OrderApiController {

    @Autowired
    JwtService jwtService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private RepaymentService repaymentService;


    @GetMapping("/api/contract/{accountId}")
    public ResponseEntity<OrderDto> getOrder(
            @CookieValue(value = "token", required = false) String token
    ) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId = jwtService.getId(token);
        log.info("[contract accountId] {}",accountId);
        OrderDto order = orderService.getOrder(accountId);
        log.info("[contract] {} ",order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/api/contract")
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

    @PostMapping("/api/contract/{applicationId}/entries")
    public ResponseEntity<EntryDto> create(@PathVariable Long applicationId,
                                 @RequestBody EntryDto entryDto,
                                 @CookieValue(value="token", required = false) String token) {
        if(!jwtService.isValid(token))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId = jwtService.getId(token);
        EntryDto createEntry=entryService.create(applicationId,entryDto,accountId);

        return new ResponseEntity<>(createEntry, HttpStatus.OK);
    }

    @PutMapping("/api/contract/{applicationId}/entries")
    public ResponseEntity<EntryDto> update(@PathVariable Long applicationId,
                                           @RequestBody EntryDto entryDto,
                                           @CookieValue(value="token", required = false) String token) {
        if(!jwtService.isValid(token))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId = jwtService.getId(token);
        EntryDto updated=entryService.update(applicationId, entryDto, accountId);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/api/contract/{applicationId}/entries")
    public ResponseEntity<EntryDto> get(@PathVariable Long applicationId,
                                        @CookieValue(value="token", required = false) String token) {
        String accountId = jwtService.getId(token);
        EntryDto entry = entryService.get(applicationId,accountId);
        return new ResponseEntity<>(entry,HttpStatus.OK);
    }

    @DeleteMapping("/api/contract/{applicationId}/entries")
    public ResponseEntity<Void> delete(@PathVariable Long applicationId) {
        entryService.delete(applicationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/api/contract/{applicationId}/repayments")
    public ResponseEntity<RepaymentDto> create(@PathVariable Long applicationId,
                                               @RequestBody RepaymentDto repaymentDto,
                                               @CookieValue(value="token", required = false) String token) {
        if(!jwtService.isValid(token))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId=jwtService.getId(token);
        RepaymentDto createRepayment=repaymentService.create(applicationId, repaymentDto,accountId);
        return new ResponseEntity<>(createRepayment, HttpStatus.OK);
    }

    @GetMapping("/api/contract/{applicationId}/repayment")
    public ResponseEntity<RepaymentDto> getPayments(@PathVariable Long applicationId) {
        RepaymentDto repayments = repaymentService.get(applicationId);
        return new ResponseEntity<>(repayments, HttpStatus.OK);
    }

    @GetMapping("/api/contract/{applicationId}/repayments")
    public ResponseEntity<List<RepaymentDto>> getPayments_list(@PathVariable Long applicationId) {
        List<RepaymentDto> repayments = repaymentService.get_list(applicationId);
        return new ResponseEntity<>(repayments, HttpStatus.OK);
    }

    @PutMapping("/api/contract/{applicationId}/repayments/{repaymentId}")
    public ResponseEntity<RepaymentDto> update(@PathVariable Long repaymentId,
                                                           @RequestBody RepaymentDto repaymentDto) {
        RepaymentDto updated= repaymentService.update(repaymentId, repaymentDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/api/contract/{applicationId}/repayments/{repaymentId}")
    public ResponseEntity<Void> deleteRepayment(@PathVariable Long repaymentId) {
        repaymentService.delete(repaymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
