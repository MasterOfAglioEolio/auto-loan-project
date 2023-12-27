package com.verystrong.car_loan_project.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomerInfo is a Querydsl query type for CustomerInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerInfo extends EntityPathBase<CustomerInfo> {

    private static final long serialVersionUID = -2095374287L;

    public static final QCustomerInfo customerInfo = new QCustomerInfo("customerInfo");

    public final NumberPath<Integer> Age = createNumber("Age", Integer.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.CarOwnedYN> carOwnedYN = createEnum("carOwnedYN", com.verystrong.car_loan_project.domain.CustomerInfo_type.CarOwnedYN.class);

    public final NumberPath<Integer> ChildCount = createNumber("ChildCount", Integer.class);

    public final NumberPath<Long> CustomerId = createNumber("CustomerId", Long.class);

    public final StringPath CustomerName = createString("CustomerName");

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.DwellingType> dwellingType = createEnum("dwellingType", com.verystrong.car_loan_project.domain.CustomerInfo_type.DwellingType.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.Education> education = createEnum("education", com.verystrong.car_loan_project.domain.CustomerInfo_type.Education.class);

    public final NumberPath<Integer> EmployedYears = createNumber("EmployedYears", Integer.class);

    public final NumberPath<Integer> FamilyCount = createNumber("FamilyCount", Integer.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.Gender> gender = createEnum("gender", com.verystrong.car_loan_project.domain.CustomerInfo_type.Gender.class);

    public final NumberPath<Integer> HouseAge = createNumber("HouseAge", Integer.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.HouseOwnedYN> houseOwnedYN = createEnum("houseOwnedYN", com.verystrong.car_loan_project.domain.CustomerInfo_type.HouseOwnedYN.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.HousingType> housingType = createEnum("housingType", com.verystrong.car_loan_project.domain.CustomerInfo_type.HousingType.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.IncomeClass> incomeClass = createEnum("incomeClass", com.verystrong.car_loan_project.domain.CustomerInfo_type.IncomeClass.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.IncomeType> incomeType = createEnum("incomeType", com.verystrong.car_loan_project.domain.CustomerInfo_type.IncomeType.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.MaritalStatus> martialStatus = createEnum("martialStatus", com.verystrong.car_loan_project.domain.CustomerInfo_type.MaritalStatus.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.Occupation> occupation = createEnum("occupation", com.verystrong.car_loan_project.domain.CustomerInfo_type.Occupation.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.OrgType> orgType = createEnum("orgType", com.verystrong.car_loan_project.domain.CustomerInfo_type.OrgType.class);

    public final EnumPath<com.verystrong.car_loan_project.domain.CustomerInfo_type.ResidenceClass> residenceClass = createEnum("residenceClass", com.verystrong.car_loan_project.domain.CustomerInfo_type.ResidenceClass.class);

    public QCustomerInfo(String variable) {
        super(CustomerInfo.class, forVariable(variable));
    }

    public QCustomerInfo(Path<? extends CustomerInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomerInfo(PathMetadata metadata) {
        super(CustomerInfo.class, metadata);
    }

}

