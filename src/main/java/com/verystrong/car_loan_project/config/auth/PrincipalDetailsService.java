package com.verystrong.car_loan_project.config.auth;

import com.verystrong.car_loan_project.entity.Account;
import com.verystrong.car_loan_project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//시큐리티 설정에서 loginProcessingUrl("/login")
//login 요청이 오면 자동으로 AccountDetailsService 테이블로 IoC 되어있는 loadAccountByUsername함수가 실행
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    // 스프링이 로그인 요청을 가로챌 대, username과 password 변수 2개를 가로챔
    // 패스워드는 알아서 체킹하니깐 신경 쓸 필요 x > username만 해당 DB에 있는지만 확인해서 리턴해주면 됨
    // 2. 리턴이 잘되면 자동으로 AccountDetails 타입을 세션으로 만들어줌(리턴된 PrincipalDetails가 세션에 저장됨)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            return null;
        } else {
            return new PrincipalDetails(account);
        }

    }
}

