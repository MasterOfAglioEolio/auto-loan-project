package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Balance;
import com.verystrong.car_loan_project.domain.Entry;
import com.verystrong.car_loan_project.domain.Repayment;
import com.verystrong.car_loan_project.dto.BalanceDto;
import com.verystrong.car_loan_project.dto.RepaymentDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import com.verystrong.car_loan_project.repository.EntryRepository;
import com.verystrong.car_loan_project.repository.RepaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepaymentServiceImpl implements RepaymentService {

    private final RepaymentRepository repaymentRepository;

    private final ApplicationRepository applicationRepository;

    private final EntryRepository entryRepository;

    private final BalanceService balanceService;

    private final ModelMapper modelMapper;


    @Override
    public Repayment create(Long applicationId, RepaymentDto dto) {
        if (!isRepayableApplication(applicationId)) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        Repayment repayment = modelMapper.map(dto, Repayment.class);
        repayment.setApplicationId(applicationId);

        repaymentRepository.save(repayment);

        Balance updatedBalance = balanceService.repaymentUpdate(applicationId,
                BalanceDto.builder() .repaymentAmount(dto.getRepaymentAmount())
                        .type(BalanceDto.RepaymentType.REMOVE)
                        .build());

        RepaymentDto response = modelMapper.map(repayment, RepaymentDto.class);

//        Response response = modelMapper.map(repayment, Response.class);
         response.setBalance(updatedBalance.getBalance());
         Repayment response_entity= modelMapper.map(response, Repayment.class);
//
         return response_entity;
    }

    @Override
    public List<Repayment> get(Long applicationId) {
        List<Repayment> repayments = repaymentRepository.findAllByApplicationId(applicationId);

        return repayments.stream().map(r -> modelMapper.map(r, Repayment.class)).collect(Collectors.toList());
    }

    @Override
    public Repayment update(Long repaymentId, RepaymentDto dto) {
        Repayment repayment = repaymentRepository.findById(repaymentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        Long applicationId = repayment.getApplicationId();
        BigDecimal beforeRepaymentAmount = repayment.getRepaymentAmount();

        balanceService.repaymentUpdate(applicationId,
                BalanceDto.builder()
                        .repaymentAmount(beforeRepaymentAmount)
                        .type(BalanceDto.RepaymentType.ADD)
                        .build()
        );

        repayment.setRepaymentAmount(dto.getRepaymentAmount());
        repaymentRepository.save(repayment);

        Balance updatedBalance = balanceService.repaymentUpdate(applicationId,
                BalanceDto.builder()
                        .repaymentAmount(dto.getRepaymentAmount())
                        .type(BalanceDto.RepaymentType.REMOVE)
                        .build()
        );
        Repayment repayment_enity =modelMapper.map(RepaymentDto.builder()
                .applicationId(applicationId)
                .beforeRepaymentAmount(beforeRepaymentAmount)
                .afterRepaymentAmount(dto.getRepaymentAmount())
                .balance(updatedBalance.getBalance())
                .createdAt(repayment.getCreatedAt())
                .updatedAt(repayment.getUpdatedAt())
                .build(),Repayment.class);



        return repayment_enity;
    }

    @Override
    public void delete(Long repaymentId) {
        Repayment repayment = repaymentRepository.findById(repaymentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        Long applicationId = repayment.getApplicationId();
        BigDecimal removeRepaymentAmount = repayment.getRepaymentAmount();

        balanceService.repaymentUpdate(applicationId
                , BalanceDto.builder()
                        .repaymentAmount(removeRepaymentAmount)
                        .type(BalanceDto.RepaymentType.ADD)
                        .build());

        repayment.setIsDeleted(true);
        repaymentRepository.save(repayment);

    }

    private boolean isRepayableApplication(Long applicationId) {
        Optional<Application> existedApplication = applicationRepository.findById(applicationId);
        if (existedApplication.isEmpty()) {
            return false;
        }

        if (existedApplication.get().getContractedAt() == null) {
            return false;
        }

        Optional<Entry> existedEntry = entryRepository.findByApplicationId(applicationId);
        return existedEntry.isPresent();
    }
}
