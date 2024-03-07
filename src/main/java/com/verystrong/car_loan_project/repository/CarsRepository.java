package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars,Long> {

    List<Cars> findByIdIn(List<Long> ids);
}
