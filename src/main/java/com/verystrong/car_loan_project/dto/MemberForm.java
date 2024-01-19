package com.verystrong.car_loan_project.dto;

import com.verystrong.car_loan_project.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String repeat;

    public Member toEntity() {
        return new Member(null, firstname, lastname, email, password, repeat);
    }
}
