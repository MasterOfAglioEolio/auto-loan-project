package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars,Long> {
}
