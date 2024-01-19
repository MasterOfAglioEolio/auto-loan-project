package com.verystrong.car_loan_project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Judgment;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.JudgmentDto;
import org.springframework.ui.Model;


public interface JudgmentService {
    JudgmentDto judgment(ApplicationDto applicationDto) throws JsonProcessingException;

    JudgmentDto get(Long judgmentId);

    JudgmentDto getJudgmentOfApplication(Long applicationId);

    JudgmentDto update(Long judgmentId, JudgmentDto dto);

    ApplicationDto grant(Long judgmentId);

    void delete(Long judgmentId);
}
