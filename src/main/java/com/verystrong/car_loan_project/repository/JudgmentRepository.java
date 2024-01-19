package com.verystrong.car_loan_project.repository;

import com.verystrong.car_loan_project.domain.Judgment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JudgmentRepository extends JpaRepository<Judgment, Long> {

    Optional<Judgment> findByApplicationId(Long applicationId);
}