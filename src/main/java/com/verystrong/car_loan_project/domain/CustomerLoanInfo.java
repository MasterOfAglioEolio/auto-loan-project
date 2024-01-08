package com.verystrong.car_loan_project.domain;

import com.verystrong.car_loan_project.domain.Application_type.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList="LoanId")
})
@Entity
public class CustomerLoanInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LoanId;

    @Setter
    @OneToOne(optional = false)
    private CustomerInfo customerInfo;

    @Setter
    @Column(nullable = false)
    private boolean defaultYN;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActiveLoanYN activeLoanYN;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanType loanType;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplWeek applWeek;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private int applHour; // 방문일시

    @Setter
    @Enumerated(EnumType.STRING)
    private Accompany accompany;

    @Setter
    @Column(nullable = false, updatable = false)
    private BigDecimal CarPrice;

    @Setter
    @Column(nullable = false, updatable = false)
    private int deposit;

    @Setter
    @Column(nullable = false)
    private int loanTerm;

    @Setter
    @Column(nullable = false)
    private int loanRemainTerm;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InterestType interestType;

    @Setter
    @Column(nullable = false, updatable = false)
    private float interestRate;

    @Setter
    @Column(nullable = false)
    private BigDecimal loanAmount;

    @Setter
    @Column(nullable = false)
    private BigDecimal installAmount;

    @Setter
    @Column(nullable = false)
    private BigDecimal loanRemainAmount;


    private CustomerLoanInfo(CustomerInfo customerInfo,
                             boolean defaultYN,
                             ActiveLoanYN activeLoanYN,
                             LoanType loanType,
                             ApplWeek applWeek,
                             int applHour,
                             Accompany accompany,
                             BigDecimal carPrice,
                             int deposit,
                             int loanTerm,
                             int loanRemainTerm,
                             InterestType interestType,
                             float interestRate,
                             BigDecimal loanAmount,
                             BigDecimal installAmount,
                             BigDecimal loanRemainAmount){
        this.customerInfo=customerInfo;
        this.defaultYN=defaultYN;
        this.activeLoanYN=activeLoanYN;
        this.loanType=loanType;
        this.applWeek=applWeek;
        this.applHour=applHour;
        this.accompany=accompany;
        CarPrice=carPrice;
        this.deposit=deposit;
        this.loanTerm=loanTerm;
        this.loanRemainTerm=loanRemainTerm;
        this.interestType=interestType;
        this.interestRate=interestRate;
        this.loanAmount=loanAmount;
        this.installAmount=installAmount;
        this.loanRemainAmount=loanRemainAmount;


    }

    public static CustomerLoanInfo of(CustomerInfo customerInfo,
                             boolean defaultYN,
                             ActiveLoanYN activeLoanYN,
                             LoanType loanType,
                             ApplWeek applWeek,
                             int applHour,
                             Accompany accompany,
                             BigDecimal carPrice,
                             int deposit,
                             int loanTerm,
                             int loanRemainTerm,
                             InterestType interestType,
                             float interestRate,
                             BigDecimal loanAmount,
                             BigDecimal installAmount,
                             BigDecimal loanRemainAmount){
        return new CustomerLoanInfo(customerInfo,
                defaultYN,
                activeLoanYN,
                loanType,
                applWeek,
                applHour,
                accompany,
                carPrice,
                deposit,
                loanTerm,
                loanRemainTerm,
                interestType,
                interestRate,
                loanAmount,
                installAmount,
                loanRemainAmount);
    }
    protected CustomerLoanInfo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerLoanInfo that)) return false;
        return LoanId != null && Objects.equals(LoanId, that.LoanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LoanId);
    }
}
