# select * from customer_info
INSERT INTO account(account_id, email, password, role) VALUES ('jyjy1284','asdf@asdf',1234,'USER');
# INSERT INTO customer_info (account_id, gender, age, education, marital_status, family_count, child_count, income_type, income_class, occupation, org_type, employed_years, house_ownedyn, dwelling_type, housing_type, residence_class, car_ownedyn) VALUES ('jyjy1284','Woman', '21.0', 'GraduateSchool', 'Single', '2', '0', 'Service', 'E', 'General_work', 'Trade', '2.3', 'Y', 'Self', 'Apartment', 'Good', 'N');
INSERT INTO cars(name,info, img_path, price) VALUES ('볼보 XC60','2.0 가솔린 T8 AWD 인스크립션','/img/RTC20231227100006780_0X.jpg',55000000);
INSERT INTO cars(name,info, img_path, price) VALUES ('제네시스 더 올 뉴 G80','3.5 가솔린 터보 AWD','/img/RTC20240122100007156_0X.jpg',45800000);
INSERT INTO cars(name,info, img_path, price) VALUES ('현대 팰리세이드','3.8 가솔린 4WD 프레스티지 8인승','/img/RTC20240112100007047_0X.jpg',36000000);
INSERT INTO cars(name,info, img_path, price) VALUES ('기아 K8 HEV','1.6 HEV 시그니처','/img/SHC20230622000004281_0X.jpg',38500000);
INSERT INTO cars(name,info, img_path, price) VALUES ('기아 모하비 더 마스터','3.0 디젤 4WD 마스터즈 5인승','/img/RTC20231026100005881_0X.jpg',35300000);
INSERT INTO cars(name,info, img_path, price) VALUES ('기아 4세대 카니발','2.2 디젤 노블레스 9인승','/img/RTC20240103100006875_0X.jpg',36400000);


INSERT INTO repayment (   application_id,    account_id,  repayment_amount,  balance, before_repayment_amount, after_repayment_amount, created_at, updated_at)
VALUES (1,'jyjy1284',100.00, 1000.00,1000.00,900.00,'2024-03-03 00:00:00','2024-03-03 00:00:00');
INSERT INTO repayment (   application_id,    account_id,  repayment_amount,  balance, before_repayment_amount, after_repayment_amount, created_at, updated_at)
VALUES (1,'jyjy1284',100.00, 900.00,10.00,150.00,'2024-03-03 00:00:00','2024-04-03 00:00:00');
INSERT INTO repayment (   application_id,    account_id,  repayment_amount,  balance, before_repayment_amount, after_repayment_amount, created_at, updated_at)
VALUES (1,'jyjy1284',100.00, 800.00,50.00,150.00,'2024-03-03 00:00:00','2024-05-03 00:00:00');
INSERT INTO repayment (   application_id,    account_id,  repayment_amount,  balance, before_repayment_amount, after_repayment_amount, created_at, updated_at)
VALUES (1,'jyjy1284',100.00, 700.00,50.00,150.00,'2024-03-03 00:00:00','2024-06-03 00:00:00');
#
# INSERT INTO QUESTION (IDX, TITLE, CONTENTS, AUTHOR, CREATED_AT) VALUES (1, '게시글 제목1', '게시글 내용1', '작성자1', '2024-01-01 23:24:00');
# INSERT INTO QUESTION (IDX, TITLE, CONTENTS, AUTHOR, CREATED_AT) VALUES (2, '게시글 제목2', '게시글 내용2', '작성자2', '2024-01-01 23:24:00');
# INSERT INTO QUESTION (IDX, TITLE, CONTENTS, AUTHOR, CREATED_AT) VALUES (3, '게시글 제목3', '게시글 내용3', '작성자3', '2024-01-01 23:24:00');
#
#
# INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (1, '게시글 제목1', '게시글 내용1', '2024-01-01 23:24:00');
# INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (2, '게시글 제목2', '게시글 내용2', '2024-01-02 23:24:00');
# INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (3, '게시글 제목3', '게시글 내용3', '2024-01-03 23:24:00');
# INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (4, '게시글 제목4', '게시글 내용4', '2024-01-04 23:24:00');
# INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (5, '게시글 제목5', '게시글 내용5', '2024-01-05 23:24:00');
