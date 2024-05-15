## 자동차 할부 대출 심사 서비스 EALC(Easy Auto Loan Check) Service

우리의 EALC 서비스는 자동차 대출 신청자의 정보를 분석하여 대출 승인 가능성과 예상 대출 금리를 제공합니다.

이를 위해 대량의 
자동차 대출 고객 정보 데이터(학습 데이터: 96,165개, 테스트 데이터: 64,074개)와
대출 신청 데이터(학습 데이터: 94,241개, 테스트 데이터: 48,055개)를 활용합니다.

 고객님께서 제공하신 데이터를 바탕으로, 우리의 서비스는 고객님의 대출 심사 결과를 신속하고 정확하게 예측해드립니다. 
이제 복잡한 대출 심사 과정을 걱정하지 마시고, EALC 서비스를 통해 간편하게 자동차 할부 대출을 체크해보세요.

# 개발 기간
2023.12.19~ 2024.02.08(개선 예정)

# Why EALC?

![오토금융현황](https://github.com/MasterOfAglioEolio/auto-loan-project/assets/123310319/97a870db-5d23-457b-ae23-78e003d74f2a)
오토금융이 카드사의 신수익원으로 떠오르고 있는 상황에서, L사의 자동차 할부금융 서비스를 예로 들어 보면, 무서류 심사 프로세스를 구축하여 고객의 이용 편의성을 높였다고 합니다. 

우리의 EALC 서비스도 이와 같은 대출심사 간소화 서비스의 한 예로, 회원가입 후 로그인을 통해 필요한 정보만 입력하면 심사 통과 여부와 예상 대출 금리를 신속하고 정확하게 안내합니다. 특히, 소득증빙 없이 심사함으로 대출 접근성을 높이고, 대출 신청 과정을 더욱 편리하게 만들어줍니다.

![image](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/a256d9ae-fd77-4037-9363-b02fc465b750)
한편, 한국은 출산율 저하로 인해 고령화 사회 국가로 진입한 지 오래되었습니다. 이에 따라 실버층이 잠재된 소비시장으로 꼽히고 있으며, 고령 금융의 관심도 높아지는 추세입니다. 이러한 상황에서 우리의 EALC 서비스는 고령 소비자를 고려하여, 전자상거래의 회원가입과 로그인 과정의 어려움을 해결하기 위해 큰글 모드와 One Page One Thing 방식을 도입하였습니다. 이를 통해 고령 소비자들이 서비스를 더욱 쉽게 이하하고 이용할 수 있도록 돕고 있습니다.  

이러한 접근 방식은 고객들의 편의성과 만족도를 높이는 동시에, 서비스 이용률을 증가시키고 대출 시장에서의 경쟁력을 강화하는 데 기여할 것으로 기대됩니다. EALC 서비스는 고객들의 다양한 요구에 부응하여 편리하고 신속한 대출 서비스를 제공하는 것을 목표로 하고 있습니다.

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

![할부금융 usecase drawio](https://github.com/MasterOfAglioEolio/auto-loan-project/assets/60294084/7865401f-061b-4594-9767-15eee3bf608a)



# Service Sample Image


## Home 화면 (기본|큰글 모드)
<table>
  <tr>
    <td align="center">
      <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/6faf0db8-05a4-41c9-825b-509c86225788" width=450 alt="home1">
    </td>
    <td align="center">
      <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/635f5b6e-d0a7-4f65-9575-c8ad1298af73" width=450 alt="home큰글모드">
    </td>
  </tr>
  <tr>
    <td align="center">
      <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/110b914b-788f-4181-8a57-48e7a9719339"  alt="home2">
    </td>
    <td align="center">
      <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/75701da9-9f74-4dc9-911b-6a3cdd1d1ebf" alt="image">
    </td>
  </tr>
</table>

## 회원가입 (기본|큰글 모드)


<table>
  <tr>
    <td align="center">
      <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/f3a418e8-00fd-4f78-b646-12b26b8b5803" width=450 alt="기본 모드">
    </td>
    <td align="center">
      <img src="https://github.com/MasterOfAglioEolio/auto-loan-project/assets/60294084/5eef53ec-336d-4797-80dd-db4fbb6bcf2c" width=450 alt="큰글 모드">
    </td>
  </tr>
  <tr>
    <td align="center">기본 모드</td>
    <td align="center">큰글 모드</td>
  </tr>
</table>


## 로그인 (기본|큰글 모드)

<table>
  <tr>
    <td align="center">
      <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/25709b25-e91e-416c-870f-43a86c044e7d" width=450 alt="기본 모드">
    </td>
    <td align="center">
      <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/1d0a2ca3-62cb-4c67-b98e-837f5293d42a" width=450 alt="큰글 모드">
    </td>
  </tr>
  <tr>
    <td align="center">기본 모드</td>
    <td align="center">큰글 모드</td>
  </tr>
</table>

## 게시판 (Q&A, 공지사항)


<p align="center">
 <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/ab0f2d4c-276c-4f4b-af3c-c2a4f9999c91" align="center">  
 <img src="https://github.com/XgitalBounce/auto-loan-project/assets/60294084/572dc741-b745-4e42-bbc5-2097d2fa5173" align="center">  
</p>


## 기본 모드 적용 시 회원 정보 입력


![정보입력_기본](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/899d8795-e26f-47f8-8f51-0256771620cd)



## 큰글 모드 적용 시 회원 정보 입력 (One Page One Thing)


![정보입력_큰글](https://github.com/XgitalBounce/auto-loan-project/assets/60294084/b4d7669b-b3de-437a-a9e3-01898a03005a)




## 심사 결과 화면 
![image](https://github.com/XgitalBounce/car-loan-project/assets/60294084/7a406d5d-5f6b-4593-baa7-91077844da28)

# TODO: 개선안

- **미구현된 기능 및 추가 예정:**
 회원 관리를 위한 Admin 서비스와 대출 집행, 상환 기능이 향후 프로젝트에 추가 된다면 더 좋은 결과물이 될 것 같습니다.

- **부족한 테스트 코드 작성:**
 개발 과정에서 테스트 코드의 부재로 인해 소프트웨어의 안정성과 품질을 보장하지 못했습니다.
 향후엔 테스트 주도 개발(TDD) 등의 방법론을 적용하여 테스트 코드 작성에 더욱 신경쓰는 것을 목표하겠습니다.

- **초기 설계 단계의 지식 부족과 시간 소모:** 
  프로젝트 초기 설계 단계에서는 HTML Thymeleaf 를 이용하여 View를 구현하였으나 이후 Vue.js 프론트엔드 설계 방식으로 전환하면서 시간이 많이 소모되었습니다. 초기 설계 단계에서 필요한 지식을 충분히 습득하고, 명확하게 계획하여 효율적이고 확장 가능한 설계를 고려해야 한다는 것을 배웠습니다.

