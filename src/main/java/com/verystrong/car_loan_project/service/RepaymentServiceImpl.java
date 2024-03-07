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
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RepaymentServiceImpl implements RepaymentService {

    private final RepaymentRepository repaymentRepository;

    private final ApplicationRepository applicationRepository;

    private final EntryRepository entryRepository;

    private final BalanceService balanceService;

    private final ModelMapper modelMapper;


    @Override
    public RepaymentDto create(Long applicationId, RepaymentDto dto,String accountId) {
        if (!isRepayableApplication(applicationId,accountId)) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        Repayment repayment = modelMapper.map(dto, Repayment.class);
        repayment.setApplicationId(applicationId);

        repaymentRepository.save(repayment);

        BalanceDto updatedBalance = balanceService.repaymentUpdate(applicationId,
                BalanceDto.builder().repaymentAmount(dto.getRepaymentAmount()).build());

        RepaymentDto response = modelMapper.map(repayment, RepaymentDto.class);

        response.setBalance(updatedBalance.getBalance());
//
         return response;
    }

    @Override
    public RepaymentDto get(Long applicationId) {
        List<Repayment> repayments = repaymentRepository.findAllByApplicationId(applicationId);

        if (!repayments.isEmpty()) { // 리스트가 비어있지 않은지 확인
            Repayment lastRepayment = repayments.get(repayments.size() - 1); // 가장 마지막 요소 가져오기
            RepaymentDto lastRepaymentDto = modelMapper.map(lastRepayment, RepaymentDto.class); // Dto로 변환
            return lastRepaymentDto;
        }

        return null; // 리스트가 비어있다면 null 반환
    }

    @Override
    public List<RepaymentDto> get_list(Long applicationId) {
        List<Repayment> repayments = repaymentRepository.findAllByApplicationId(applicationId);
        java.lang.reflect.Type targetListType = new TypeToken<List<RepaymentDto>>() {}.getType();
        List<RepaymentDto> repaymentDtos=modelMapper.map(repayments, targetListType);
        return repaymentDtos;
    }

    @Override
    public RepaymentDto update(Long repaymentId, RepaymentDto dto) {
        Repayment repayment = repaymentRepository.findById(repaymentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        Long applicationId = repayment.getApplicationId();
        BigDecimal beforeRepaymentAmount = repayment.getRepaymentAmount();

        balanceService.repaymentUpdate(applicationId,
                BalanceDto.builder()
                        .repaymentAmount(beforeRepaymentAmount)
                        .build()
        );

        repayment.setRepaymentAmount(dto.getRepaymentAmount());
        repaymentRepository.save(repayment);

        BalanceDto updatedBalance = balanceService.repaymentUpdate(applicationId,
                BalanceDto.builder()
                        .repaymentAmount(dto.getRepaymentAmount())
                        .build()
        );
        repayment.setRepaymentAmount(dto.getRepaymentAmount());
        repayment.setBalance(updatedBalance.getBalance());
        repayment.setCreatedAt(repayment.getCreatedAt());
        repayment.setUpdatedAt(repayment.getUpdatedAt());


        return modelMapper.map(repayment,RepaymentDto.class);
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
//                        .type(BalanceDto.RepaymentType.ADD)
                        .build());

        repaymentRepository.delete(repayment);

    }

    private boolean isRepayableApplication(Long applicationId, String accountId) {
        Optional<Application> existedApplication = applicationRepository.findById(applicationId);
        if (existedApplication.isEmpty()) {
            return false;
        }

//        if (existedApplication.get().getContractedAt() == null) {
//            return false;
//        }

        Optional<Entry> existedEntry = entryRepository.findByApplicationIdAndAccountId(applicationId,accountId);
        return existedEntry.isPresent();
    }
}
