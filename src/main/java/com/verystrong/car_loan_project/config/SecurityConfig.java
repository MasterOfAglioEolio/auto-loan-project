package com.verystrong.car_loan_project.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                                .requestMatchers(
                                        HttpMethod.GET,
                                        "/",
                                        "/login",
                                        "/accounts/new"
                                ).permitAll()

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        return http
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .formLogin(Customizer.withDefaults()).build();
//    }
                ).formLogin(login -> login
                        .loginPage("/login") //get 인증이 필요한 주소 요청시 실행
                        .loginProcessingUrl("/login") //post (로그인 인증 시)-> 시큐리티가 로그인 프로세스 진행
                        .usernameParameter("userName")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true) //로그인 성공 시
                        .failureForwardUrl("/login?error")
                        .permitAll())
                .logout(Customizer.withDefaults());
        return http.build();
    }
//
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}


}
