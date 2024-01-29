package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.AccountRepository;
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

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;
    @Override
    public CustomerInfoDto create(CustomerInfoDto dto,String accountId) {

        // customerInfo 설정
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("고객 정보를 찾을 수 없습니다."));

        log.info("[Register customerInfo] Request :: {}",dto);
        //1. DTO를 엔티티로 변환
        CustomerInfo customerInfo = modelMapper.map(dto ,CustomerInfo.class);
        customerInfo.setAccountId(accountId);
//     CustomerInfo customerInfo =modelMapper.map(customerInfoDto, CustomerInfo.class); //TODO : 나중에 리팩토링 이거로 바꾸기
        log.info("DTO to entity {}",customerInfo);

        //2. 리퍼지토리로 엔티티를 DB에 저장
        CustomerInfo saved = customerInfoRepository.save(customerInfo);

        log.info("[ModelMapper]{}",modelMapper.map(saved, CustomerInfoDto.class));
        return  modelMapper.map(saved, CustomerInfoDto.class);

    }

    @Override
    public CustomerInfoDto get(String accountId) {

        log.info("show customerInfo account id = "+accountId);
       CustomerInfo customerInfo= customerInfoRepository.findByAccountId(accountId);
        return modelMapper.map(customerInfo, CustomerInfoDto.class);
    }

    @Override
    public CustomerInfoDto update(CustomerInfoDto dto, String accountId) {
        log.info("update form to String"+dto.toString());
        //1. DTO를 엔티티로 변환
        CustomerInfo customerInfo = modelMapper.map(dto,CustomerInfo.class);
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
    public void delete(String accountId) {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1.삭제할 대상 가져오기
        CustomerInfo target = customerInfoRepository.findByAccountId(accountId);
        log.info("target"+target.toString());
        // 2. 대상 엔티티 삭제하기
        if (target != null){
            customerInfoRepository.delete(target);
        }

    }
}
