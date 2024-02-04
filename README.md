![할부금융 usecase drawio](https://github.com/XgitalBounce/car-loan-project/assets/60294084/b9d691b9-1b56-4dad-a0e0-e63ddbe43896) 자동차 할부 대출 심사 서비스 EALC(Easy Auto Loan Check) Service

우리의 EALC 서비스는 자동차 대출 신청자의 정보를 분석하여 대출 승인 가능성과 예상 대출 금리를 제공합니다.

이를 위해 대량의 
자동차 대출 고객 정보 데이터(학습 데이터: 96,165개, 테스트 데이터: 64,074개)와
대출 신청 데이터(학습 데이터: 94,241개, 테스트 데이터: 48,055개)를 활용합니다.

 고객님께서 제공하신 데이터를 바탕으로, 우리의 서비스는 고객님의 대출 심사 결과를 신속하고 정확하게 예측해드립니다. 
이제 복잡한 대출 심사 과정을 걱정하지 마시고, EALC 서비스를 통해 간편하게 자동차 할부 대출을 체크해보세요.


## 개발 환경

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

### 대출 심사 결과 에 대한 종속변수

|Dependent Variable|Description|Model Category|
|------|---|---|
|Default|대출 심사 승인 여부(PASS OR FAIL)|categorical|
|interestRate|대출 예상 금리|BigDecimal|


TODO :: ML SCORE 추가


## ERD

![car-loan-project-erd drawio](https://github.com/XgitalBounce/car-loan-project/assets/60294084/4d322c8a-ba2d-49da-a3c2-36f6064758ab)#


## Use Case

![Uploading 할부금융 usecase.drawio.svg…]()



Restful 방식 
* 로그인(Spring Security & JWT)
* 게시글, 댓글 CURD
* 회원정보 입력 및 대출 심사 신청 CRUD
* Machine Learning Model을 이용한 대출 심사   
