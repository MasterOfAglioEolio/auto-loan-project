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
@Table(indexes = {
        @Index(columnList="applicationId"),
        @Index(columnList="name")
})
@Builder
@Entity
public class Application{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//    @Column(nullable = false, updatable = false)
    private Long applicationId;

    @OneToOne
    @JoinColumn(name = "customerId")
    private CustomerInfo customerInfo;

    @Column(nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cellPhone;

    @Column(nullable = false)
    private BigDecimal carPrice; // 차량 가격 //TODO : 뷰에 추가하고 Deposit 비율로 LoanAmount(hopeAmount 바꾸기) 계산

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

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private LocalDateTime maturity; //만기 TODO: 신청일자 기준 + loanTerm 으로 계산

//    @Column(columnDefinition = "decimal(15,2)")
//    private BigDecimal hopeAmount; // 대출 신청 금액 (TODO : 계산해서 알려주기)

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @Column(nullable = false)
//    private LocalDateTime appliedAt; // 신청일자

//    @Column(columnDefinition = "decimal(15,2)")
//    private BigDecimal approvalAmount;  // TODO : 삭제 고려
//
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private LocalDateTime contractedAt; //약정일자


}
