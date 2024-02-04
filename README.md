# 자동차 할부 대출 심사 서비스 EALC(Easy Auto Loan Check) Service

우리의 EALC 서비스는 자동차 대출 신청자의 정보를 분석하여 대출 승인 가능성과 예상 대출 금리를 제공합니다.

이를 위해 대량의 
자동차 대출 고객 정보 데이터(학습 데이터: 96,165개, 테스트 데이터: 64,074개)와
대출 신청 데이터(학습 데이터: 94,241개, 테스트 데이터: 48,055개)를 활용합니다.

 고객님께서 제공하신 데이터를 바탕으로, 우리의 서비스는 고객님의 대출 심사 결과를 신속하고 정확하게 예측해드립니다. 
이제 복잡한 대출 심사 과정을 걱정하지 마시고, EALC 서비스를 통해 간편하게 자동차 할부 대출을 체크해보세요.


## 개발 환경

### Front End
* Vue 3.4.15
* BootStrap

### Back End

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

### ML
* Anacond - Jupyter Notebook

### 기술 세부
* Pandas
* Pickle
* Matplotlib
* seaborn
* sklearn


Restful 방식 
* 로그인(Spring Security & JWT)
* 게시글, 댓글 CURD
* 회원정보 입력 및 대출 심사 신청 CRUD
* Machine Learning Model을 이용한 대출 심사   
