package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Balance;
import com.verystrong.car_loan_project.domain.Entry;
import com.verystrong.car_loan_project.domain.Repayment;
import com.verystrong.car_loan_project.dto.BalanceDto;
import com.verystrong.car_loan_project.dto.EntryDto;
import com.verystrong.car_loan_project.dto.RepaymentDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import com.verystrong.car_loan_project.repository.BalanceRepository;
import com.verystrong.car_loan_project.repository.EntryRepository;
import com.verystrong.car_loan_project.repository.RepaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService{
    private final EntryRepository entryRepository;

    private final ApplicationRepository applicationRepository;

    private final RepaymentRepository repaymentRepository;

    private final BalanceRepository balanceRepository;

    private final BalanceService balanceService;

    private final ModelMapper modelMapper;

    private final RepaymentService repaymentService;

    @Override
    public EntryDto create(Long applicationId, EntryDto dto, String accountId) {
        if (!isContractedApplication(applicationId)) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }
        Entry entry = modelMapper.map(dto, Entry.class);
        entry.setApplicationId(applicationId);
        entry.setAccountId(accountId);


        entryRepository.save(entry);
        log.info("[Entry create check]{}",entry);

        balanceService.create(applicationId,
                BalanceDto.builder()
                        .balance(dto.getEntryAmount())
                        .build()
                ,accountId);

        // Repayment 생성 조건 검사 및 생성
        List<Repayment> repayments = repaymentRepository.findAllByApplicationId(applicationId);
        if (repayments.isEmpty()) { // 리스트가 비어있는 경우
            log.info("[check repayment balance]{}",entry.getEntryAmount());
            RepaymentDto repaymentDto = new RepaymentDto();
            repaymentDto.setBalance(entry.getEntryAmount());
            repaymentDto.setCreatedAt(LocalDateTime.now());
            repaymentDto.setUpdatedAt(LocalDateTime.now());

            repaymentService.create(applicationId,repaymentDto,accountId);
        }

        // Repayment 생성 조건 검사 및 생성
        Optional<Balance> balance = balanceRepository.findByApplicationId(applicationId);
        if (balance.isEmpty()) { // 리스트가 비어있는 경우
            BalanceDto balanceDto = new BalanceDto();
            log.info("[check entry balance]{}",entry.getEntryAmount());
            balanceDto.setBalance(entry.getEntryAmount());
            balanceDto.setCreatedAt(LocalDateTime.now());
            balanceDto.setUpdatedAt(LocalDateTime.now());

            balanceService.create(applicationId,balanceDto,accountId);
        }



        return modelMapper.map(entry,EntryDto.class);
    }

    @Override
    public EntryDto get(Long applicationId,String accountId) {
        Entry entry = entryRepository.findByApplicationIdAndAccountId(applicationId,accountId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

//        return modelMapper.map(entry, Response.class);
        return modelMapper.map(entry, EntryDto.class);
    }

    @Transactional
    @Override
    public EntryDto update(Long entryId, EntryDto dto,String accountId) {
        Entry entry = entryRepository.findById(entryId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        BigDecimal beforeEntryAmount = entry.getEntryAmount();
        entry.setEntryAmount(dto.getEntryAmount());

        entryRepository.save(entry);

        Long applicationId = entry.getApplicationId();
        balanceService.update(applicationId,
                BalanceDto.builder()
                        .beforeEntryAmount(beforeEntryAmount)
                        .afterEntryAmount(dto.getEntryAmount())
                        .build()
        );


        Entry.builder()
                .applicationId(entry.getApplicationId())
                .beforeEntryAmount(beforeEntryAmount)
                .afterEntryAmount(entry.getEntryAmount())
                .build();

        return modelMapper.map(entry, EntryDto.class);
    }




    @Transactional
    @Override
    public void delete(Long entryId) {
        Entry entry = entryRepository.findById(entryId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });




        BigDecimal beforeEntryAmount = entry.getEntryAmount();

        Long applicationId = entry.getApplicationId();
        balanceService.update(applicationId,
                BalanceDto.builder()
                        .beforeEntryAmount(beforeEntryAmount)
                        .afterEntryAmount(BigDecimal.ZERO)
                        .build()
        );

        entryRepository.delete(entry);

    }

    private boolean isContractedApplication(Long applicationId) {
        Optional<Application> existed = applicationRepository.findById(applicationId);
        if (existed.isEmpty()) {
            return false;
        }
        return true;

//        return existed.get().getContractedAt() != null;
    }
}
