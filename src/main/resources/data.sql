# select * from customer_info
INSERT INTO account(account_id, email, password, role) VALUES ('jyjy1284','asdf@asdf',1234,'USER');
INSERT INTO customer_info (account_id, gender, age, education, marital_status, family_count, child_count, income_type, income_class, occupation, org_type, employed_years, house_ownedyn, dwelling_type, housing_type, residence_class, car_ownedyn) VALUES ('jyjy1284','Woman', '21.0', 'GraduateSchool', 'Single', '2', '0', 'Service', 'E', 'General_work', 'Trade', '2.3', 'Y', 'Self', 'Apartment', 'Good', 'N');
INSERT INTO cars(name,info, img_path, price) VALUES ('볼보 XC60','2.0 가솔린 T8 AWD 인스크립션','/img/RTC20231227100006780_0X.jpg',55000000);
INSERT INTO cars(name,info, img_path, price) VALUES ('제네시스 더 올 뉴 G80','3.5 가솔린 터보 AWD','/img/RTC20240122100007156_0X.jpg',45800000);
INSERT INTO cars(name,info, img_path, price) VALUES ('현대 팰리세이드','3.8 가솔린 4WD 프레스티지 8인승','/img/RTC20240112100007047_0X.jpg',36000000);
INSERT INTO cars(name,info, img_path, price) VALUES ('기아 K8 HEV','1.6 HEV 시그니처','/img/SHC20230622000004281_0X.jpg',38500000);

