package com.verystrong.car_loan_project.domain;

import com.verystrong.car_loan_project.domain.Application_type.InterestType;
import com.verystrong.car_loan_project.domain.Application_type.LoanType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor    // 모든 컬럼 생성자 생성
@NoArgsConstructor    // 기본 생성자
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String accountId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private String cellPhone;

    @Column(nullable = false)
    private BigDecimal carPrice; //TODO : 뷰에 추가하고 Deposit 비율로 LoanAmount(hopeAmount 바꾸기) 계산

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    @Column(nullable = false)
    private Integer deposit;

    @Column(nullable = false)
    private Integer loanTerm;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InterestType interestType;

    @Column(columnDefinition = "decimal(5,4)")
    private BigDecimal interestRate; // 예상금리   // TODO: 예상해서 알려주기

    @Column(length = 500)
    private String items;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime maturity; //만기 TODO: 신청일자 기준 + loanTerm 으로 계산


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false)
    private LocalDateTime appliedAt; // 신청일자

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime contractedAt; //약정일자

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal approvalAmount;  // 대출 승인 금액 (TODO : 계산해서 알려주기)// TODO : 삭제 고려


}
