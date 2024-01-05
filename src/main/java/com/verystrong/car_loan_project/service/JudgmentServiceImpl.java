package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Judgment;
import com.verystrong.car_loan_project.dto.JudgmentDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import com.verystrong.car_loan_project.repository.JudgmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class JudgmentServiceImpl implements JudgmentService {

    private final JudgmentRepository judgmentRepository;

    private final ApplicationRepository applicationRepository;

    private final ModelMapper modelMapper;

    @Override
    public Judgment create(JudgmentDto dto) {
        Long applicationId = dto.getApplicationId();
        if (!isPresentApplication(applicationId)) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        Judgment judgment = modelMapper.map(dto, Judgment.class);

        Judgment saved = judgmentRepository.save(judgment);
//        return modelMapper.map(saved, JudgmentDto.class);
        return saved;

    }

    @Override
    public Judgment get(Long judgmentId) {
        Judgment judgment = judgmentRepository.findById(judgmentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

//        return modelMapper.map(judgment, JudgmentDTO.Response.class);
        return judgment;
    }

    @Override
    public Judgment getJudgmentOfApplication(Long applicationId) {
        if (!isPresentApplication(applicationId)) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        Judgment judgment = judgmentRepository.findByApplicationId(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

//        return modelMapper.map(judgment, JudgmentDTO.Response.class);
        return judgment;
    }

    @Override
    public Judgment update(Long judgmentId, JudgmentDto dto) {
        Judgment judgment = judgmentRepository.findById(judgmentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        judgment.setName(dto.getName());
        judgment.setApprovalAmount(dto.getApprovalAmount());

        Judgment saved = judgmentRepository.save(judgment);

//        return modelMapper.map(judgment, JudgmentDTO.Response.class);
        return saved;
    }

    @Override
    public void delete(Long judgmentId) {
        Judgment judgment = judgmentRepository.findById(judgmentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        judgment.setIsDeleted(true);

        judgmentRepository.save(judgment);

    }

    @Override
    public Application grant(Long judgmentId) {
        Judgment judgment = judgmentRepository.findById(judgmentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        Long applicationId = judgment.getApplicationId();

        Application application = applicationRepository.findById(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        BigDecimal approvalAmount = judgment.getApprovalAmount();
        application.setApprovalAmount(approvalAmount);

        Application saved = applicationRepository.save(application);

        log.info("check grant {}",saved);
        return saved; // 체크 필요
    }

    private boolean isPresentApplication(Long applicationId) {
        return applicationRepository.findById(applicationId).isPresent();
    }
}
