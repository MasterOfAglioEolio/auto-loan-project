package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.Entry;
import com.verystrong.car_loan_project.dto.BalanceDto;
import com.verystrong.car_loan_project.dto.EntryDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import com.verystrong.car_loan_project.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService{
    private final EntryRepository entryRepository;

    private final ApplicationRepository applicationRepository;

    private final BalanceService balanceService;

    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public Entry create(Long applicationId, EntryDto dto) {
        if (!isContractedApplication(applicationId)) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        Entry entry = modelMapper.map(dto, Entry.class);
        entry.setApplicationId(applicationId);

        entryRepository.save(entry);

        balanceService.create(applicationId,
                BalanceDto.builder()
                        .entryAmount(dto.getEntryAmount())
                        .build()
        );

//        return modelMapper.map(entry, Response.class);
        return entry;
    }

    @Override
    public Entry get(Long applicationId) {
        Entry entry = entryRepository.findByApplicationId(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

//        return modelMapper.map(entry, Response.class);
        return entry;
    }

    @Transactional
    @Override
    public Entry update(Long entryId, EntryDto dto) {
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


        return Entry.builder()
                .applicationId(entry.getApplicationId())
                .beforeEntryAmount(beforeEntryAmount)
                .afterEntryAmount(entry.getEntryAmount())
                .build();
    }

    @Transactional
    @Override
    public void delete(Long entryId) {
        Entry entry = entryRepository.findById(entryId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        entry.setIsDeleted(true);

        entryRepository.save(entry);

        BigDecimal beforeEntryAmount = entry.getEntryAmount();

        Long applicationId = entry.getApplicationId();
        balanceService.update(applicationId,
                BalanceDto.builder()
                        .beforeEntryAmount(beforeEntryAmount)
                        .afterEntryAmount(BigDecimal.ZERO)
                        .build()
        );

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
