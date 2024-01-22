package com.verystrong.car_loan_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth-> auth.anyRequest().permitAll());
//                        .requestMatchers(
//                                HttpMethod.GET,
//                                "/",
//                                "/accounts",
//                                "/accounts/new"
//                        ).permitAll());
//                ).formLogin(login -> login
//                        .loginPage("/members/login")
//                        .loginProcessingUrl("/login-process")
//                        .usernameParameter("userid")
//                        .passwordParameter("pw")
//                        .defaultSuccessUrl("/loginSuccess", true)
//                        .failureForwardUrl("/login?error")
//                        .permitAll())
//                .logout(Customizer.withDefaults());
        return http.build();
//
//
    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//}

}
