package com.verystrong.car_loan_project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerLoanInfo is a Querydsl query type for CustomerLoanInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerLoanInfo extends EntityPathBase<CustomerLoanInfo> {

    private static final long serialVersionUID = -1487673407L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerLoanInfo customerLoanInfo = new QCustomerLoanInfo("customerLoanInfo");

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.Accompany> accompany = createEnum("accompany", com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.Accompany.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.ActiveLoanYN> activeLoanYN = createEnum("activeLoanYN", com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.ActiveLoanYN.class);

    public final NumberPath<Integer> applHour = createNumber("applHour", Integer.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.ApplWeek> applWeek = createEnum("applWeek", com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.ApplWeek.class);

    public final NumberPath<java.math.BigDecimal> CarPrice = createNumber("CarPrice", java.math.BigDecimal.class);

    public final QCustomerInfo customerInfo;

    public final BooleanPath defaultYN = createBoolean("defaultYN");

    public final NumberPath<Integer> deposit = createNumber("deposit", Integer.class);

    public final NumberPath<java.math.BigDecimal> installAmount = createNumber("installAmount", java.math.BigDecimal.class);

    public final NumberPath<Float> interestRate = createNumber("interestRate", Float.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.InterestType> interestType = createEnum("interestType", com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.InterestType.class);

    public final NumberPath<java.math.BigDecimal> loanAmount = createNumber("loanAmount", java.math.BigDecimal.class);

    public final NumberPath<Long> LoanId = createNumber("LoanId", Long.class);

    public final NumberPath<java.math.BigDecimal> loanRemainAmount = createNumber("loanRemainAmount", java.math.BigDecimal.class);

    public final NumberPath<Integer> loanRemainTerm = createNumber("loanRemainTerm", Integer.class);

    public final NumberPath<Integer> loanTerm = createNumber("loanTerm", Integer.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.LoanType> loanType = createEnum("loanType", com.verystrong.car_loan_project.domain.CustomerLoanInfo_type.LoanType.class);

    public QCustomerLoanInfo(String variable) {
        this(CustomerLoanInfo.class, forVariable(variable), INITS);
    }

    public QCustomerLoanInfo(Path<? extends CustomerLoanInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerLoanInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerLoanInfo(PathMetadata metadata, PathInits inits) {
        this(CustomerLoanInfo.class, metadata, inits);
    }

    public QCustomerLoanInfo(Class<? extends CustomerLoanInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customerInfo = inits.isInitialized("customerInfo") ? new QCustomerInfo(forProperty("customerInfo")) : null;
    }

}

