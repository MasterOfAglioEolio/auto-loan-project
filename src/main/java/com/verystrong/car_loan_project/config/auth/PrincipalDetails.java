package com.verystrong.car_loan_project.config.auth;

import com.verystrong.car_loan_project.entity.Account;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인 진행이 완료되면 시큐리티 세션을 만들어준다. (Security ContextHolder)
// 오브젝트 => Authentication 타입 객체
// Authentication 객체 안에 User 정보가 있어야한다.
// User 오브젝트 타입 => UserDetails 타입 객체

// Security Session => Authentication => UserDetails

@Data
public class PrincipalDetails implements UserDetails{

    private Account account; //컴포지션
    public PrincipalDetails(Account account){
        this.account = account;
    }
    // 해당 account의 권한 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> collect = new ArrayList<>();

        // 람다 표현식으로 변경
        collect.add(() -> account.getRole().toString());

        return collect;
    }

    //get Password 메서드
    @Override
    public String getPassword(){
        return account.getPassword();
    }
    //get username 메서드
    @Override
    public String getUsername(){
        return account.getUserName();
    }
    // 계정이 만료 되었는지 (true: 만료X)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겼는지 (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되었는지 (true: 만료X)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화(사용가능)인지 (true: 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
