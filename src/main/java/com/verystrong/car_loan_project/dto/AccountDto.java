package com.verystrong.car_loan_project.dto;

import lombok.*;

@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AccountDto {
    private Long id;

    private String password;

    private String username;

    private String name;

    private String email;


    @Builder
    public AccountDto(String password,String name, String email) {
        this.password = password;
        this.name = name;
        this.email = email;

    }

}
