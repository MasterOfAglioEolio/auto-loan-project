package com.verystrong.car_loan_project.dto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AccountDto {
    private Long id;

    private String password;

    private String userName;

    private String email;


}
