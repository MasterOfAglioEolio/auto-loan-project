/* import.sql */

INSERT INTO QUESTION (IDX, TITLE, CONTENTS, AUTHOR, CREATED_AT) VALUES (1, '대출신청', '할부 진행 시 필요한 서류가 뭔가요?', '포코', '2024-01-01 23:24:00');
INSERT INTO QUESTION (IDX, TITLE, CONTENTS, AUTHOR, CREATED_AT) VALUES (2, '대출상환', '남아있는 할부금을 일부상환/중도상환 가능한가요?', '프리', '2024-01-01 23:24:00');
INSERT INTO QUESTION (IDX, TITLE, CONTENTS, AUTHOR, CREATED_AT) VALUES (3, '대출신청', '올해 20살 되는데 대출 가능할까요?', '코린이', '2024-01-01 23:24:00');


INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (1, '게시글 제목1', '게시글 내용1', '2024-01-01 23:24:00');
INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (2, '게시글 제목2', '게시글 내용2', '2024-01-02 23:24:00');
INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (3, '게시글 제목3', '게시글 내용3', '2024-01-03 23:24:00');
INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (4, '게시글 제목4', '게시글 내용4', '2024-01-04 23:24:00');
INSERT INTO BOARD (IDX, TITLE, CONTENTS, CREATED_AT) VALUES (5, '게시글 제목5', '게시글 내용5', '2024-01-05 23:24:00');

INSERT INTO COMMENT (IDX, CONTENTS, CREATED_AT) VALUES (1, '자동차매매계약서, 면허증, 재직 및 소득증빙 서류가 필요합니다','2024-01-05 23:24:00');
INSERT INTO COMMENT (IDX, CONTENTS, CREATED_AT) VALUES (2, '네, 가능합니다. 다만, 일부/중도 상환 시 중도상환수수료가 발생합니다. 실시간 결제를 원하시는 경우 홈페이지를 통해 처리 가능하며, 입금전용계좌는 기존에 이용했던 계좌를 통해 입금 가능합니다','2024-01-05 23:24:00');
INSERT INTO COMMENT (IDX, CONTENTS, CREATED_AT) VALUES (3,'소득 증빙이 가능한 만 19세 이상의 고객부터 가능하시며 만 25세 미만의 경우 차량(매매)가격의 80%까지만 대출이 가능합니다','2024-01-05 23:24:00');