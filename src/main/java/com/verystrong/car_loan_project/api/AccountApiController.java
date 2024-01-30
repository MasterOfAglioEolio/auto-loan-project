package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.dto.AccountDto;
import com.verystrong.car_loan_project.repository.AccountRepository;
import com.verystrong.car_loan_project.service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestController
public class AccountApiController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/api/sign")
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountDto accountDto) {
        log.info("[check data]{}",accountDto);
        try {
            log.info("[account create]");
            accountService.create(accountDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            log.info("[Error]");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IllegalAccessException e) {
            log.info("[Error]");
            throw new RuntimeException(e);
        }
    }

}