package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerInfoServiceImpl implements CustomerInfoService{

    private final CustomerInfoRepository customerInfoRepository;

    private final ModelMapper modelMapper;
    @Override
    public CustomerInfoDto create(CustomerInfoDto dto) {

        log.info("[Register customerInfo] Request :: {}",dto);
        //1. DTO를 엔티티로 변환
        CustomerInfo customerInfo = modelMapper.map(dto,CustomerInfo.class);
//     CustomerInfo customerInfo =modelMapper.map(customerInfoDto, CustomerInfo.class); //TODO : 나중에 리팩토링 이거로 바꾸기
        log.info("DTO to entity {}",customerInfo);

        //2. 리퍼지토리로 엔티티를 DB에 저장
        CustomerInfo saved = customerInfoRepository.save(customerInfo);

        log.info("[ModelMapper]{}",modelMapper.map(saved, CustomerInfoDto.class));
        return  modelMapper.map(saved, CustomerInfoDto.class);

    }

    @Override
    public CustomerInfoDto get(Long customerId) {

        log.info("show customer id = "+customerId);
       CustomerInfo customerInfo= customerInfoRepository.findById(customerId).orElseThrow(() -> {
           throw new BaseException(ResultType.SYSTEM_ERROR);
       });

        return modelMapper.map(customerInfo, CustomerInfoDto.class);
    }

    @Override
    public CustomerInfoDto update(CustomerInfoDto dto) {
        log.info("update form to String"+dto.toString());
        //1. DTO를 엔티티로 변환
        CustomerInfo customerInfo = dto.toEntity();
//        CustomerInfo customerInfo = modelMapper.map(dto, CustomerInfo.class);
        log.info("customerInfo to DTO {}",customerInfo.toString());
        //2. id 찾기
        CustomerInfo target = customerInfoRepository.findById(customerInfo.getCustomerId()).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        //3. 리퍼지토리로 엔티티를 DB에 저장
        if (target!=null) {
            CustomerInfo saved =customerInfoRepository.save(customerInfo);
            log.info("DTO to Repository {}",saved.toString());
            return modelMapper.map(saved,CustomerInfoDto.class);
        }
        return null;
    }

    @Override
    public void delete(Long customerId) {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1.삭제할 대상 가져오기
        CustomerInfo target = customerInfoRepository.findById(customerId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        log.info("target"+target.toString());
        // 2. 대상 엔티티 삭제하기
        if (target != null){
            customerInfoRepository.delete(target);

        }

    }
}
