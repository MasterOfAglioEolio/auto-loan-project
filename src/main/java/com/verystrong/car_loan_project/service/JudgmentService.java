package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Judgment;
import com.verystrong.car_loan_project.dto.JudgmentDto;


public interface JudgmentService {
    Judgment create(JudgmentDto dto);

    Judgment get(Long judgmentId);

    Judgment getJudgmentOfApplication(Long applicationId);

    Judgment update(Long judgmentId, JudgmentDto dto);

    Application grant(Long judgmentId);

    void delete(Long judgmentId);
}
