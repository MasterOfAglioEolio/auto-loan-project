package com.verystrong.car_loan_project.domain;

import com.verystrong.car_loan_project.domain.Account_type.AccountRole;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Setter
@Getter
@ToString
@NoArgsConstructor    // 기본 생성자
@Table(indexes = {
        @Index(columnList="account_id")
})
@Builder
@Entity
public class Account{
    @Id
    private String accountId;

    @Column(nullable = false)
//    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;


    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private AccountRole role;


    private Account(String accountId, String password, String email, AccountRole role) {
        this.accountId = accountId;
        this.password = password;
        this.email = email;
        this.role=role;
    }

    public static Account of(String accountId, String password, String email, AccountRole role){
        return new Account(accountId,password,email,role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }







}
