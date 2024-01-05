package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Balance;
import com.verystrong.car_loan_project.dto.BalanceDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService{

    private final BalanceRepository balanceRepository;

    private final ModelMapper modelMapper;
    @Override
    public Balance create(Long applicationId, BalanceDto dto) {
        Balance balance = modelMapper.map(dto, Balance.class);

        // 첫 생성은 entry amount 를 balance
        BigDecimal entryAmount = dto.getEntryAmount();
        balance.setApplicationId(applicationId);
        balance.setBalance(entryAmount);

        balanceRepository.findAllByApplicationId(applicationId).ifPresent(b -> {
            balance.setBalanceId(b.getBalanceId());
            balance.setIsDeleted(b.getIsDeleted());
            balance.setCreatedAt(b.getCreatedAt());
            balance.setUpdatedAt(LocalDateTime.now());
        });

        Balance saved = balanceRepository.save(balance);

//        return modelMapper.map(saved, BalanceDto.class);
        return saved;

    }

    @Override
    public Balance get(Long applicationId) {
        Balance balance = balanceRepository.findById(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
//        return modelMapper.map(balance, Response.class);
        return balance;
    }

    @Override
    public Balance update(Long applicationId, BalanceDto dto) {
        Balance balance = balanceRepository.findByApplicationId(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        BigDecimal beforeEntryAmount = dto.getBeforeEntryAmount();
        BigDecimal afterEntryAmount = dto.getAfterEntryAmount();
        BigDecimal updatedBalance = balance.getBalance();
        updatedBalance = updatedBalance.subtract(beforeEntryAmount).add(afterEntryAmount);

        balance.setBalance(updatedBalance);

        Balance updated = balanceRepository.save(balance);

//        return modelMapper.map(updated, Response.class);
        return updated;
    }

    @Override
    public Balance repaymentUpdate(Long applicationId, BalanceDto dto) {
        Balance balance = balanceRepository.findByApplicationId(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        BigDecimal updatedBalance = balance.getBalance();
        BigDecimal repaymentAmount = dto.getRepaymentAmount();

        if (dto.getType().equals(BalanceDto.RepaymentType.ADD)) {
            updatedBalance = updatedBalance.add(repaymentAmount);
        } else {
            updatedBalance = updatedBalance.subtract(repaymentAmount);
        }

        balance.setBalance(updatedBalance);

        Balance updated = balanceRepository.save(balance);

//        return modelMapper.map(updated, Response.class);
        return updated;
    }

    @Override
    public void delete(Long applicationId) {
        Balance balance = balanceRepository.findByApplicationId(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        balance.setIsDeleted(true);

        balanceRepository.save(balance);

    }
}
