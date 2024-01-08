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
public class Application extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, updatable = false)
    private Long applicationId;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String cellPhone;

//    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    private Integer deposit;

    private Integer loanTerm;

    @Enumerated(EnumType.STRING)
    private InterestType interestType;

    //    @Column(nullable = false)
    @Column(columnDefinition = "decimal(5,4)")
    private BigDecimal interestRate; // 금리

//    @Column(nullable = false)
    @Column(columnDefinition = "decimal(5,4)")
    private BigDecimal fee; // 취급 수수료

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @Column(nullable = false)
    private LocalDateTime maturity; //만기

    //    @Column(nullable = false)
    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal hopeAmount; // 대출 신청 금액


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @Column(nullable = false)
    private LocalDateTime appliedAt; // 신청일자

    @Column(columnDefinition = "decimal(15,2)")
    private BigDecimal approvalAmount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime contractedAt; //약정일자


}
