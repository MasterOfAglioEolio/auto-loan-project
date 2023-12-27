package com.verystrong.car_loan_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/customerinfo")
@Controller
public class CustomerInfoController {

    @GetMapping
    public String customerinfo(ModelMap map)
    {
        map.addAttribute("customerinfo", List.of());
        return "customerinfo/index";
    }
}
