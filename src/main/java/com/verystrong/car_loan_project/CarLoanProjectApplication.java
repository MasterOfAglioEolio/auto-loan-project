package com.verystrong.car_loan_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CarLoanProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarLoanProjectApplication.class, args);
    }

}
