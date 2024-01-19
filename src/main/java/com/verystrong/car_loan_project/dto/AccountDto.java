package com.verystrong.car_loan_project.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AccountDto {
    private Long id;

    private String password;

    private String username;

    private String name;

    private String cellPhone;


}
