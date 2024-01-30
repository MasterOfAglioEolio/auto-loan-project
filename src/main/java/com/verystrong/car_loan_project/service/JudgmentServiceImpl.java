package com.verystrong.car_loan_project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verystrong.car_loan_project.domain.Application;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.domain.Judgment;
import com.verystrong.car_loan_project.dto.ApplicationDto;
import com.verystrong.car_loan_project.dto.JudgmentDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.ApplicationRepository;
import com.verystrong.car_loan_project.repository.CustomerInfoRepository;
import com.verystrong.car_loan_project.repository.JudgmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class JudgmentServiceImpl implements JudgmentService {

    @Autowired
    private ApplicationService applicationService;

    private final JudgmentRepository judgmentRepository;

    private final ApplicationRepository applicationRepository;

    private final CustomerInfoRepository customerInfoRepository;

    private final ModelMapper modelMapper;

    String flaskUrl = "http://localhost:5001/api/judgment"; // Flask 서버의 URL을 입력하세요.

    @Override
    public JudgmentDto judgment(String accountId) throws JsonProcessingException {
        log.info("[Find accountId]{}", accountId);
        CustomerInfo customerInfo = customerInfoRepository.findByAccountId(accountId);
        log.info("[Find customerInfo]{}", customerInfo);

        Application find_application = applicationRepository.findByCustomerInfo_CustomerId(customerInfo.getCustomerId());
        log.info("[Find applicaition]{}", find_application);

        ApplicationDto application = modelMapper.map(find_application, ApplicationDto.class);

        log.info("[Judgement]{}", application);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ApplicationDto> request = new HttpEntity<>(application, headers);

//        ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, request, String.class);
        ResponseEntity<String> responseEntity = restTemplate.exchange(flaskUrl, HttpMethod.POST,
                request, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String responseBody = responseEntity.getBody();
            System.out.println("Flask 서버 응답: " + responseBody);
        } else {
            System.out.println("Flask 서버 응답 실패");
        }
//
        String response = responseEntity.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        JudgmentDto judgmentDto = objectMapper.readValue(response, JudgmentDto.class);
        Judgment judgment = modelMapper.map(judgmentDto, Judgment.class);
        judgment.setAccountId(accountId);
        System.out.println("to dto: " + judgment);
        Judgment saved = judgmentRepository.save(judgment);

        System.out.println("saved: " + saved);
//        return modelMapper.map(saved, JudgmentDto.class);
        return modelMapper.map(saved, JudgmentDto.class);

    }

    @Override
    public JudgmentDto get(String accountId) {
        Judgment judgment = judgmentRepository.findByAccountId(accountId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

//        return modelMapper.map(judgment, JudgmentDTO.Response.class);
        return modelMapper.map(judgment, JudgmentDto.class);
    }

//    @Override
//    public JudgmentDto getJudgmentOfApplication(Long applicationId) {
//        if (!isPresentApplication(applicationId)) {
//            throw new BaseException(ResultType.SYSTEM_ERROR);
//        }
//
//        Judgment judgment = judgmentRepository.findByApplicationId(applicationId).orElseThrow(() -> {
//            throw new BaseException(ResultType.SYSTEM_ERROR);
//        });
//
////        return modelMapper.map(judgment, JudgmentDTO.Response.class);
//        return modelMapper.map(judgment,JudgmentDto.class);
//    }

    @Override
    public JudgmentDto update(Long judgmentId, JudgmentDto dto) {
        Judgment judgment = judgmentRepository.findById(judgmentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

//        judgment.setName(dto.getName());
//        judgment.setApprovalAmount(dto.getApprovalAmount());

        Judgment saved = judgmentRepository.save(judgment);

//        return modelMapper.map(judgment, JudgmentDTO.Response.class);
        return modelMapper.map(saved, JudgmentDto.class);
    }

    @Override
    public void delete(Long judgmentId) {
        Judgment judgment = judgmentRepository.findById(judgmentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });

//        judgment.setIsDeleted(true);

        judgmentRepository.save(judgment);

    }

    @Override
    public ApplicationDto grant(Long judgmentId) {
        Judgment judgment = judgmentRepository.findById(judgmentId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        return null;

//        String accountId = judgment.getAccountId();
//
//        Application application = applicationRepository.findById(accountId).orElseThrow(() -> {
//            throw new BaseException(ResultType.SYSTEM_ERROR);
//        });
//
////        BigDecimal approvalAmount = judgment.getApprovalAmount();
////        application.setApprovalAmount(approvalAmount);
//
//        Application saved = applicationRepository.save(application);
//
//        log.info("check grant {}",saved);
//        return modelMapper.map(saved, ApplicationDto.class); // 체크 필요
//    }

//    private boolean isPresentApplication(String accountId) {
//        return applicationRepository.findByAccountId(accountId).isPresent();
//    }
    }
}
