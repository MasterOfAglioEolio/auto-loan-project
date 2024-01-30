package com.verystrong.car_loan_project.config;


import com.verystrong.car_loan_project.dto.AccountDto;
import com.verystrong.car_loan_project.dto.Security.BoardPrincipal;
import com.verystrong.car_loan_project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).build();
// =======
//         return http
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                         .requestMatchers(
//                                 HttpMethod.GET,
//                                 "/",
//                                 "/login",
//                                 "/accounts/new"
//                         ).permitAll()
//                         .requestMatchers(
//                                "/bootstrap/**" //staticresource 허용
//                         ).permitAll()
//                         .requestMatchers(
//                                 HttpMethod.POST,
//                                 "/login",
//                                 "/accounts/new"
//                         ).permitAll()  // 회원 가입 POST 요청 허용
//                         .anyRequest().authenticated()
//                 )
//                 .formLogin(
//                         login -> login
// //                        .loginPage("/loginPage") //get 인증이 필요한 주소 요청시 실행
// //                        .loginProcessingUrl("/loginPage") //post (로그인 인증 시)-> 시큐리티가 로그인 프로세스 진행
//                         .usernameParameter("username")
//                         .passwordParameter("password")
//                         .defaultSuccessUrl("/", true) //로그인 성공 시
//                         .failureForwardUrl("/login?error")
//                         .permitAll())
//                 .logout(logout -> logout
//                         .logoutSuccessUrl("/")
//                         .deleteCookies("JSESSIONID") // 로그아웃 후 쿠키삭제
//                         .permitAll()).
//                 build();
// >>>>>>> main
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                        .requestMatchers(
//                                HttpMethod.GET,
//                                "/",
//                                "/login",
//                                "/accounts/new"
//                        ).permitAll()
//                        .requestMatchers(
//                               "/bootstrap/**" //staticresource 허용
//                        ).permitAll()
//                        .requestMatchers(
//                                HttpMethod.POST,
//                                "/login",
//                                "/accounts/new"
//                        ).permitAll()  // 회원 가입 POST 요청 허용
//                        .anyRequest().authenticated()
//                )
//                .formLogin(
//                        login -> login
////                        .loginPage("/loginPage") //get 인증이 필요한 주소 요청시 실행
////                        .loginProcessingUrl("/loginPage") //post (로그인 인증 시)-> 시큐리티가 로그인 프로세스 진행
////                        .usernameParameter("username")
////                        .passwordParameter("password")
//                        .defaultSuccessUrl("/", true) //로그인 성공 시
//                        .failureForwardUrl("/login?error")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                        .deleteCookies("JSESSIONID") // 로그아웃 후 쿠키삭제
//                        .permitAll()).
//                build();
//    }
    @Bean
    public UserDetailsService userDetailsService(AccountRepository accountRepository){
        return username -> accountRepository
                .findById(username)
                .map(AccountDto::from)
                .map(BoardPrincipal::from)
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username));
    }

        @Bean
        public PasswordEncoder passwordEncoder () { //TODO : SpringSecurity 오류 해결 후 수정
            return new BCryptPasswordEncoder();
        }





    }

