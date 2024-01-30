package com.verystrong.car_loan_project.api;

import com.verystrong.car_loan_project.domain.Cars;
import com.verystrong.car_loan_project.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarApiController {

    @Autowired
    CarsRepository carsRepository;

    @GetMapping("/api/cars")
    public List<Cars> getItems(){
        List<Cars> cars = carsRepository.findAll();

        return cars;
    }
}
