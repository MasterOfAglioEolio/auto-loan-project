package com.verystrong.car_loan_project.domain;

import jakarta.persistence.*;
import lombok.*;

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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String name;

    private String cellPhone;

    private String email;

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
