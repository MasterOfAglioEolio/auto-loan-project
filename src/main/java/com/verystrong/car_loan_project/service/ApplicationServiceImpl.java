package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.AcceptTerms;
import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.domain.Terms;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{
    private final TermsRepository termsRepository;

    private final AcceptTermsRepository acceptTermsRepository;

    private final ApplicationRepository applicationRepository;

    private final CustomerInfoRepository customerInfoRepository;

    private final JudgmentRepository judgmentRepository;

    private final ModelMapper modelMapper;
    @Override
    public ApplicationDto create(ApplicationDto dto,Long customerId) {
        Application application = modelMapper.map(dto,Application.class);

        // customerInfo 설정
        CustomerInfo customerInfo = customerInfoRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("고객 정보를 찾을 수 없습니다."));

        application.setMaturity(LocalDateTime.now().plusMonths(application.getLoanTerm()));
        application.setAppliedAt(LocalDateTime.now());
        application.setIsDeleted(false);
        application.setCustomerInfo(customerInfo);


//        application.setCustomerInfo(customerInfo);
        log.info("[Create] application : {}",application);

        Application applied=applicationRepository.save(application);
        log.info("DTO to Repositroy {} ",applied);
        //return modelMapper.map(applied,ApplicationDto.class); //TODO : 리팩토링 시 전체 적용하기
        return modelMapper.map(applied,ApplicationDto.class);
    }

    @Override
    public ApplicationDto get(Long applicationId) {
        log.info("show customer id = "+applicationId);
        //1. id를 조회해 데이터 가져오기
        log.info("show data="+applicationRepository.findById(applicationId));
        Application customerInfo= applicationRepository.findById(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        return modelMapper.map(customerInfo,ApplicationDto.class);
    }

    @Override
    public ApplicationDto update(ApplicationDto dto) {
        log.info("update form to String"+dto.toString());
        //1. DTO를 엔티티로 변환
        Application application = modelMapper.map(dto,Application.class);
        log.info("customerInfo to DTO {}",application.toString());
        //2. id 찾기
        Application target = applicationRepository.findById(application.getApplicationId()).orElse(null);
        application.setName(dto.getName());
        application.setCellPhone(dto.getCellPhone());
        application.setEmail(dto.getEmail());
        application.setHopeAmount(dto.getHopeAmount());
        if (target!=null) {
            Application saved =applicationRepository.save(application);
            log.info("DTO to Repository {}",saved.toString());
            //4. 수정 결과 페이지로 리다이렉트
            return modelMapper.map(saved,ApplicationDto.class);
        }
        return null;
    }

    @Override
    public void delete(Long applicationId) {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1.삭제할 대상 가져오기
        Application target = applicationRepository.findById(applicationId).orElse(null);
        log.info("target"+target.toString());
        // 2. 대상 엔티티 삭제하기
        if (target != null){
            applicationRepository.delete(target);

        }

    }

    @Override
    public Boolean acceptTerms(Long applicationId, ApplicationDto.AcceptTerms terms) {
        applicationRepository.findById(applicationId).orElse(null);
        //terms Id 기준 정렬
        List<Terms> termsList = termsRepository.findAll(Sort.by(Sort.Direction.ASC, "termsId"));
        if (termsList.isEmpty()){
            throw new BaseException(ResultType.SYSTEM_ERROR); //조회할 약관이 없으면 에러
        }

        List<Long> acceptTermsIds = terms.getAcceptTermsIds();
        if (termsList.size() !=acceptTermsIds.size()){
            throw new BaseException(ResultType.SYSTEM_ERROR); //여러개의 약관과 우리가 관리하는 약관의 개수가 다르면 에러
        }

        List<Long> termsIds = termsList.stream().map(Terms::getTermsId).collect(Collectors.toList());
        Collections.sort(acceptTermsIds);

        if (!termsIds.containsAll(acceptTermsIds)) {
            throw new BaseException(ResultType.SYSTEM_ERROR); //약관에 존재하지 않는 약관에 동의 시 에러
        }

        for (Long termsId : acceptTermsIds) {
            AcceptTerms accepted = AcceptTerms.builder()
                    .termsId(termsId)
                    .applicationId(applicationId)
                    .build();

            acceptTermsRepository.save(accepted);
        }

        return true;

    }

    @Override
    public ApplicationDto contract(Long applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        judgmentRepository.findByApplicationId(applicationId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

        if (application.getApprovalAmount() == null
                || application.getApprovalAmount().compareTo(BigDecimal.ZERO) == 0) {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        }

        application.setContractedAt(LocalDateTime.now());

        Application updated = applicationRepository.save(application);

//        return modelMapper.map(updated, Response.class);
        return modelMapper.map(updated,ApplicationDto.class);
    }
}
