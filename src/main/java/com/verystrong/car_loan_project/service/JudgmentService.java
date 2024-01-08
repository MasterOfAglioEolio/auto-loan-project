package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Judgment;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.JudgmentDto;


public interface JudgmentService {
    JudgmentDto create(JudgmentDto dto);

    JudgmentDto get(Long judgmentId);

    JudgmentDto getJudgmentOfApplication(Long applicationId);

    JudgmentDto update(Long judgmentId, JudgmentDto dto);

    ApplicationDto grant(Long judgmentId);

    void delete(Long judgmentId);
}
