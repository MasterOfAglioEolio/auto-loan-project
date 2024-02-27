package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.AccountRepository;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import com.verystrong.car_loan_project.service.JwtService;
import com.verystrong.car_loan_project.service.JwtServiceImpl;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestController
public class LoginApiController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/api/login")
    public ResponseEntity loginPage() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res){
        log.info("[LoginCheck]:{}",params);
        Account account = accountRepository.findByAccountId(params.get("account_id"));
        log.info("[Account]:{}",account);
        if(account != null && passwordEncoder.matches(params.get("password"), account.getPassword())){
            JwtService jwtService = new JwtServiceImpl();
            String account_id = account.getAccountId();
            String token = jwtService.getToken("account_id",account_id);
            log.info("[Token] id:{} token:{}",account_id,token);
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);

            return new ResponseEntity<>(account_id, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/logout")
    public ResponseEntity logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        res.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        String accountId = jwtService.getId(token);


        log.info("[Check Id]:{}",accountId);
        return new ResponseEntity<>(accountId, HttpStatus.OK);

    }

    @GetMapping("/api/check-info")
    public ResponseEntity check_info(@CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }



        String accountId = jwtService.getId(token);
        Account account = accountRepository.findByAccountId(accountId);
        CustomerInfo customerInfo = customerInfoRepository.findByAccount(account);


        if (customerInfo != null) {
            log.info("[Check Info]:{}", customerInfo.getCustomerId());

            return new ResponseEntity<>(customerInfo.getCustomerId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);


    }

    @GetMapping("/api/check-application")
    public ResponseEntity check_application(@CookieValue(value = "token", required = false) String token) {
        if(!jwtService.isValid(token))
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Claims claims = jwtService.getClaims(token);

        String accountId=jwtService.getId(token);
        Account account = accountRepository.findByAccountId(accountId);
        CustomerInfo customerInfo= customerInfoRepository.findByAccount(account);
        if (customerInfo != null) {
            Application application = applicationRepository.findByCustomerInfo_CustomerId(customerInfo.getCustomerId());
            if (application != null) {
                log.info("[Check Application]:{}", application.getApplicationId());
                return new ResponseEntity<>(application.getApplicationId(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
