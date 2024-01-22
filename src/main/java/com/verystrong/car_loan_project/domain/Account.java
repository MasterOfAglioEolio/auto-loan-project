package com.verystrong.car_loan_project.domain;

import com.verystrong.car_loan_project.domain.Account_type.AccountRole;
import com.verystrong.car_loan_project.dto.AccountDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@Setter
@Getter
@ToString
@AllArgsConstructor    // 모든 컬럼 생성자 생성
@NoArgsConstructor    // 기본 생성자
@Table(indexes = {
        @Index(columnList="AccountId")
//        @Index(columnList="CustomerName")
})
@Builder
@Entity
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
//    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private AccountRole role;

    @Builder
    public Account(String password, String name, String email, AccountRole role) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.role=role;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
