package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.repository.AccountRepository;
import com.verystrong.car_loan_project.service.JwtService;
import com.verystrong.car_loan_project.service.JwtServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestController
public class LoginApiController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res){
        log.info("[LoginCheck]:{}",params);
        Account account = accountRepository.findByAccountIdAndPassword(params.get("account_id"),params.get("password"));

        if(account!=null){
            JwtService jwtService = new JwtServiceImpl();
            String account_id = account.getAccountId();
            String token = jwtService.getToken("account_id",account_id);

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);

            return new ResponseEntity<>(account_id, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
