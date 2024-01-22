package com.verystrong.car_loan_project.service;

import com.verystrong.car_loan_project.domain.Account;
import com.verystrong.car_loan_project.domain.Account_type.AccountRole;
import com.verystrong.car_loan_project.domain.CustomerInfo;
import com.verystrong.car_loan_project.dto.AccountDto;
import com.verystrong.car_loan_project.dto.CustomerInfoDto;
import com.verystrong.car_loan_project.exception.BaseException;
import com.verystrong.car_loan_project.exception.ResultType;
import com.verystrong.car_loan_project.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AccountDto create(AccountDto dto){
        log.info("[Register Account] Request :: {}",dto);

        //1. DTO를 엔티티로 변환
//        Account account = modelMapper.map(dto ,Account.class);
//     CustomerInfo customerInfo =modelMapper.map(customerInfoDto, CustomerInfo.class); //TODO : 나중에 리팩토링 이거로 바꾸기
        Account account = Account.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))  //암호화처리
                .role(AccountRole.USER)
                .build();
        log.info("DTO to entity {}",account);
        validateDuplicateAccount(account);

        //2. 리퍼지토리로 엔티티를 DB에 저장
        Account saved = accountRepository.save(account);

        log.info("[ModelMapper]{}",modelMapper.map(saved, AccountDto.class));
        return  modelMapper.map(saved, AccountDto.class);
    }

    @Override
    public void validateDuplicateAccount(Account account) {
        Account findaccount  = accountRepository.findByEmail(account.getEmail());
        if (findaccount != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }


    }

    @Override
    public AccountDto get(Long accountId) {
        log.info("show account id = "+accountId);
        Account account= accountRepository.findById(accountId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });


        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto update(AccountDto dto) {
        log.info("update form to String"+dto.toString());
        //1. DTO를 엔티티로 변환
        Account account = modelMapper.map(dto,Account.class);
//        CustomerInfo customerInfo = modelMapper.map(dto, CustomerInfo.class);
        log.info("account to DTO {}",account.toString());
        //2. id 찾기
        Account target = accountRepository.findById(account.getId()).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        //3. 리퍼지토리로 엔티티를 DB에 저장
        if (target!=null) {
            Account saved =accountRepository.save(account);
            log.info("DTO to Repository {}",saved.toString());
            return modelMapper.map(saved,AccountDto.class);
        }
        return null;
    }


    @Override
    public void delete(Long accountId) {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1.삭제할 대상 가져오기
        Account target = accountRepository.findById(accountId).orElseThrow(() -> {
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        log.info("target"+target.toString());
        // 2. 대상 엔티티 삭제하기
        if (target != null){
            accountRepository.delete(target);

        }
    }
}
