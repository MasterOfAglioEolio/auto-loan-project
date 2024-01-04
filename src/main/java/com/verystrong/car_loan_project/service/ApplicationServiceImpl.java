package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;
    @Override
    public Application create(ApplicationDto dto) {
        Application application = modelMapper.map(dto,Application.class);
        application.setAppliedAt(LocalDateTime.now());
        application.setIsDeleted(false); // TODO : 일단 테스트용으로 false 설정
        log.info("[Create] application : {}",application);

        Application applied=applicationRepository.save(application);
        log.info("DTO to Repositroy {} ",applied);
        //return modelMapper.map(applied,ApplicationDto.class); //TODO : 리팩토링 시 전체 적용하기
        return applied;
    }

    @Override
    public Application get(Long applicationId) {
        log.info("show customer id = "+applicationId);
        //1. id를 조회해 데이터 가져오기

        return applicationRepository.findById(applicationId).orElse(null);
    }

    @Override
    public Application update(ApplicationDto dto) {
        log.info("update form to String"+dto.toString());
        //1. DTO를 엔티티로 변환
        Application application = dto.toEntity();
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
            return saved;
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
}
