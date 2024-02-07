# 자동차 할부 대출 심사 서비스 EALC(Easy Auto Loan Check) Service

우리의 EALC 서비스는 자동차 대출 신청자의 정보를 분석하여 대출 승인 가능성과 예상 대출 금리를 제공합니다.

이를 위해 대량의 
자동차 대출 고객 정보 데이터(학습 데이터: 96,165개, 테스트 데이터: 64,074개)와
대출 신청 데이터(학습 데이터: 94,241개, 테스트 데이터: 48,055개)를 활용합니다.

 고객님께서 제공하신 데이터를 바탕으로, 우리의 서비스는 고객님의 대출 심사 결과를 신속하고 정확하게 예측해드립니다. 
이제 복잡한 대출 심사 과정을 걱정하지 마시고, EALC 서비스를 통해 간편하게 자동차 할부 대출을 체크해보세요.

# Why EALC?

![image](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/a256d9ae-fd77-4037-9363-b02fc465b750)


# 프로젝트 목표

* Restful API 설계 
* 로그인(Spring Security & JWT) 인증 기능 구현
* 게시글, 댓글 CURD 기능 구현
* 회원정보 입력 및 대출 심사 신청 CRUD 기능 구현
* Machine Learning Model을 이용한 대출 심사 결과 제공(대출 심사 승인 여부, 대출 예상 금리)
* 고령 이용자를 위한 큰글 모드 및 One Page One Thing 방식 UI 제공   



# 개발 환경

![서버 구조](https://github.com/XgitalBounce/car-loan-project/assets/60294084/0d3f222c-6e17-4e8d-be70-b4567da87fdf)


## Front End

#### Vue.js
* Vue 3.4.15
* BootStrap

## Back End

#### SpringBoot
* Intellij IDEA Ultimate 
* Java 17
* Gradle 8.5
* Spring Boot 3.2.0

#### 기술 세부
* Spring Data JPA
* MySQL
* H2
* Spring Security
* SpringDoc OpenAPI
* Jakarta Validation API 3.0.2
* JJWT 0.11.5
* Spring Boot Actuator
* ModelMapper 3.1.0
* Lombok
* Spring Boot DevTools
* Spring Boot Configuration Processor 


#### Flask
* Pycharm Community
* Python 3.10.11
* Flask 3.0.0

## ML
* Anacond - Jupyter Notebook

### 기술 세부
* Pandas
* Pickle
* Matplotlib
* seaborn
* sklearn

## Machine Learning Data Model

|Predictor/Independent Variable|Description|Units|
|------|---|---|
|gender|성별 데이터|categorical|
|age|나이 데이터|float|
|education|교육 수준 데이터|categorical|
|maritalStatus|혼인 상태 데이터|categorical|
|familyCount|가족 수 데이터|integer|
|childCount|자녀 수 데이터|integer|
|incomeType|소득 유형 데이터|categorical|
|incomeClass|소득 클래스 데이터|categorical|
|occupation|직업 데이터|categorical|
|orgType|조직 유형 데이터|categorical|
|employedYears|재직 기간 데이터 (IF NULL == 퇴직자)|float|
|houseOwnedYN|집 소유 여부 데이터|categorical|
|dwellingType|거주 유형 데이터|categorical|
|housingType|주택 유형 데이터|categorical|
|residenceClass|거주지 클래스 데이터|categorical|
|carOwnedYN|자동차 소유 여부 데이터|categorical|
|loanType|대출 유형 데이터|categorical|
|carPrice|자동차 가격 데이터|BigDecimal|
|deposit|예금 데이터|integer|
|loanTerm|대출 기간 데이터|integer|
|interestType|이자율 유형 데이터|categorical|

### 대출 심사 결과에 대한 종속변수

|Dependent Variable|Description|Model Category|
|------|---|---|
|Default|대출 심사 승인 여부(PASS OR FAIL)|categorical|
|interestRate|대출 예상 금리|BigDecimal|


### Model Information

|Judgement Loan Model(retire)|Interest Rate Model(retire)|Judgement Loan Model(incumbent)|Interest Rate Model(incumbent)|
|------|---|------|---|
|Algorithm: RandomForest|Algorithm: GBM|Algorithm: RandomForest|Algorithm: GBM|
|Model Category: Binary Classification|Model Catelgory: Regression|Model Category: Binary Classification|Model Catelgory: Regression|
|n_estimators: 10|ntrees: 100|n_estimators: 10|ntrees: 100|
|max_depth: 6|max_depth: 5|max_depth: 6|max_depth: 5|
|min_samples_leaf : 8|learn_rate: 0.05|min_samples_leaf : 8|learn_rate: 0.05|
|min_samples_split : 8|---|min_samples_split : 8|---|
|AUC on valid: 0.606|R2: 0.99|AUC on valid: 0.671|R2: 0.99|


## DB ERD

![car-loan-project-erd drawio](https://github.com/XgitalBounce/car-loan-project/assets/60294084/4d322c8a-ba2d-49da-a3c2-36f6064758ab)#


## Use Case

![image](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/1d446223-6900-4425-85ad-4e23b30b9b4d)



# Service Sample Image

## Home 화면
![home1](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/6faf0db8-05a4-41c9-825b-509c86225788)

![home2](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/110b914b-788f-4181-8a57-48e7a9719339)

## Home 큰글 모드 적용
![home큰글모드](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/635f5b6e-d0a7-4f65-9575-c8ad1298af73)

## 로그인, 회원가입 화면 

![image](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/f3a418e8-00fd-4f78-b646-12b26b8b5803)
![image](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/25709b25-e91e-416c-870f-43a86c044e7d)

## 큰글 모드 적용 로그인, 회원가입 화면 (One Page One Thing)

![image](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/b2427fd0-75fa-4e4b-a67a-16b398528848)
![image](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/e6c99703-6596-4784-8088-212f188443b9)



## 게시판 (Q&A, 공지사항)

<figure class="half"> 
 <a href="link"><img src=https://github.com/XgitalBounce/auto-loan-project/assets/60294084/ab0f2d4c-276c-4f4b-af3c-c2a4f9999c91 align='left'></a> 
 <a href="link"><img src=https://github.com/XgitalBounce/auto-loan-project/assets/60294084/572dc741-b745-4e42-bbc5-2097d2fa5173 align='right'></a> 
</figure>

<p align="center">
 <img src="이미지경로" align="center" width="32%">  
 <img src="이미지경로" align="center" width="32%">  
 <img src="이미지경로" align="center" width="32%">  
</p>



## 기본 모드 적용 시 회원 정보 입력


![정보입력_기본](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/899d8795-e26f-47f8-8f51-0256771620cd)



## 큰글 모드 적용 시 회원 정보 입력 (One Page One Thing)


![정보입력_큰글](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/b4d7669b-b3de-437a-a9e3-01898a03005a)




## 심사 결과 화면 
![image](https://github.com/XgitalBounce/car-loan-project/assets/60294084/7a406d5d-5f6b-4593-baa7-91077844da28)

# TODO: 개선안

* ADMIN SERVICE 개발
* 대출 집행, 상환 기능 개발
* CHAT GPT 연동 대출 상담 서비스 개발

