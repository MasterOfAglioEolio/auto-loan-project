package com.verystrong.car_loan_project.controller;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.dto.AccountDto;
import com.verystrong.car_loan_project.service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/accounts")
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/new")
    public String accountForm(Model model){
        log.info("[accountForm]");
        model.addAttribute("accountFormDto", new AccountDto());
        return "accounts/accountForm";
    }

    @PostMapping("/new")
    public String create_account(@Valid AccountDto accountDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("[binding has error]");
            return "accounts/accountForm";
        }

        try {
            log.info("[account create]");
            accountService.create(accountDto);
            return "redirect:/";

        } catch (IllegalStateException e) {
            log.info("[Error2]");
            model.addAttribute("errorMessage", e.getMessage());
            return "accounts/accountForm";
        } catch (IllegalAccessException e) {
            log.info("[Error2]");
            throw new RuntimeException(e);
        }
    }
}