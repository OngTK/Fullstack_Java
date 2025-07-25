drop database if exists dookDackMarket;
create database dookDackMarket;
use dookDackMarket;

create table product(
pNo int not null auto_increment,	-- 물품번호(PK)
pName varchar(30) not null,			-- 물품명
pSeller varchar(30) not null,		-- 판매자 
pMemo longtext,						-- 설명
pPrice int not null,				-- 가격
pPw varchar(30) not null,			-- 비밀번호
pDate datetime default now(),	-- 등록일시
pStatus bool default false,			-- 판매여부
constraint primary key(pNo)			-- PK 선언
);

create table qna(
qNo int not null auto_increment,	-- 문의번호(PK)
pNo int not null,					-- 물품번호(FK)
qQuestioner varchar(30) not null,	-- 문의자
qContent longtext not null,			-- 문의내용	
qPw varchar(30) not null,			-- 문의 비밀번호
qDate datetime default now(),	-- 문의일시	
constraint primary key(qno),		-- PK 선언
constraint foreign key(pNo) references product(pNo) -- FK선언
);

-- product 샘플
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (1, '유리구두', '신데렐라', '유리구두에 대한 설명입니다.', 4800, '2108', '2025-04-13 01:00:00', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (2, '반짝구두', '신데렐라', '반짝구두에 대한 설명입니다.', 3400, '2282', '2025-04-13 06:46:31', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (3, '무도회드레스', '신데렐라', '무도회드레스에 대한 설명입니다.', 76500, '3618', '2025-04-13 12:33:03', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (4, '호박마차', '신데렐라', '호박마차에 대한 설명입니다.', 80300, '5034', '2025-04-13 18:19:35', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (5, '왕자편지', '신데렐라', '왕자편지에 대한 설명입니다.', 72900, '4493', '2025-04-14 00:06:07', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (6, '마법시계', '신데렐라', '마법시계에 대한 설명입니다.', 46500, '6043', '2025-04-14 05:52:39', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (7, '유리왕관', '신데렐라', '유리왕관에 대한 설명입니다.', 69200, '8048', '2025-04-14 11:39:11', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (8, '꿈의구두', '신데렐라', '꿈의구두에 대한 설명입니다.', 29500, '7739', '2025-04-14 17:25:42', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (9, '동화책', '신데렐라', '동화책에 대한 설명입니다.', 11600, '3651', '2025-04-14 23:12:14', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (10, '마법거울', '신데렐라', '마법거울에 대한 설명입니다.', 5500, '3362', '2025-04-15 04:58:46', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (11, '무도회초대장', '신데렐라', '무도회초대장에 대한 설명입니다.', 9000, '3120', '2025-04-15 10:45:18', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (12, '신데렐라인형', '신데렐라', '신데렐라인형에 대한 설명입니다.', 54300, '3113', '2025-04-15 16:31:50', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (13, '도적검', '홍길동', '도적검에 대한 설명입니다.', 58700, '2330', '2025-04-15 22:18:22', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (14, '홍길동복장', '홍길동', '홍길동복장에 대한 설명입니다.', 54300, '8833', '2025-04-16 04:04:53', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (15, '의적가방', '홍길동', '의적가방에 대한 설명입니다.', 14600, '4967', '2025-04-16 09:51:25', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (16, '비밀지도', '홍길동', '비밀지도에 대한 설명입니다.', 38600, '9878', '2025-04-16 15:37:57', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (17, '정의의깃발', '홍길동', '정의의깃발에 대한 설명입니다.', 15000, '4280', '2025-04-16 21:24:29', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (18, '의적망토', '홍길동', '의적망토에 대한 설명입니다.', 4500, '7547', '2025-04-17 03:11:01', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (19, '홍길동책', '홍길동', '홍길동책에 대한 설명입니다.', 83300, '4917', '2025-04-17 08:57:33', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (20, '독사과', '백설공주', '독사과에 대한 설명입니다.', 90000, '4181', '2025-04-17 14:44:04', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (21, '마법거울', '백설공주', '마법거울에 대한 설명입니다.', 40700, '4249', '2025-04-17 20:30:36', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (22, '숲속의집', '백설공주', '숲속의집에 대한 설명입니다.', 45000, '6223', '2025-04-18 02:17:08', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (23, '일곱난쟁이인형', '백설공주', '일곱난쟁이인형에 대한 설명입니다.', 29600, '9423', '2025-04-18 08:03:40', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (24, '왕자편지', '백설공주', '왕자편지에 대한 설명입니다.', 68500, '2509', '2025-04-18 13:50:12', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (25, '마법지팡이', '해리포터', '마법지팡이에 대한 설명입니다.', 93300, '7358', '2025-04-18 19:36:44', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (26, '투명망토', '해리포터', '투명망토에 대한 설명입니다.', 80600, '8455', '2025-04-19 01:23:15', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (27, '호그와트편지', '해리포터', '호그와트편지에 대한 설명입니다.', 98500, '7288', '2025-04-19 07:09:47', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (28, '마법책', '해리포터', '마법책에 대한 설명입니다.', 48200, '4114', '2025-04-19 12:56:19', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (29, '퀴디치공', '해리포터', '퀴디치공에 대한 설명입니다.', 91700, '7633', '2025-04-19 18:42:51', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (30, '어디로든문', '도라에몽', '어디로든문에 대한 설명입니다.', 39400, '5585', '2025-04-20 00:29:23', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (31, '타임머신', '도라에몽', '타임머신에 대한 설명입니다.', 19100, '4377', '2025-04-20 06:15:55', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (32, '대나무헬리콥터', '도라에몽', '대나무헬리콥터에 대한 설명입니다.', 35800, '3490', '2025-04-20 12:02:26', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (33, '진구인형', '도라에몽', '진구인형에 대한 설명입니다.', 16400, '2777', '2025-04-20 17:48:58', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (34, '비밀도구상자', '도라에몽', '비밀도구상자에 대한 설명입니다.', 54500, '6457', '2025-04-20 23:35:30', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (35, '날아라망토', '슈퍼맨', '날아라망토에 대한 설명입니다.', 62400, '4095', '2025-04-21 05:22:02', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (36, '슈퍼복장', '슈퍼맨', '슈퍼복장에 대한 설명입니다.', 89200, '4665', '2025-04-21 11:08:34', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (37, '크립톤돌', '슈퍼맨', '크립톤돌에 대한 설명입니다.', 15800, '2741', '2025-04-21 16:55:06', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (38, '히어로책', '슈퍼맨', '히어로책에 대한 설명입니다.', 34700, '2823', '2025-04-21 22:41:37', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (39, '슈퍼벨트', '슈퍼맨', '슈퍼벨트에 대한 설명입니다.', 46800, '6775', '2025-04-22 04:28:09', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (40, '은촛대', '장발장', '은촛대에 대한 설명입니다.', 15300, '3018', '2025-04-22 10:14:41', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (41, '감옥열쇠', '장발장', '감옥열쇠에 대한 설명입니다.', 68400, '4753', '2025-04-22 16:01:13', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (42, '장발장책', '장발장', '장발장책에 대한 설명입니다.', 4000, '2463', '2025-04-22 21:47:45', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (43, '정의의편지', '장발장', '정의의편지에 대한 설명입니다.', 51900, '1706', '2025-04-23 03:34:17', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (44, '빵조각', '장발장', '빵조각에 대한 설명입니다.', 45200, '2505', '2025-04-23 09:20:48', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (45, '변신벨트', '가면라이더', '변신벨트에 대한 설명입니다.', 72100, '6282', '2025-04-23 15:07:20', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (46, '라이더헬멧', '가면라이더', '라이더헬멧에 대한 설명입니다.', 34500, '1822', '2025-04-23 20:53:52', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (47, '오토바이모형', '가면라이더', '오토바이모형에 대한 설명입니다.', 69400, '5239', '2025-04-24 02:40:24', false);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (48, '히어로카드', '가면라이더', '히어로카드에 대한 설명입니다.', 12400, '3164', '2025-04-24 08:26:56', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (49, '라이더장갑', '가면라이더', '라이더장갑에 대한 설명입니다.', 24500, '7912', '2025-04-24 14:13:28', true);
INSERT INTO product (pNo, pName, pSeller, pMemo, pPrice, pPW, pDate, pStatus) VALUES (50, '가면라이더책', '가면라이더', '가면라이더책에 대한 설명입니다.', 68700, '7475', '2025-04-24 20:00:00', true);

-- qna 샘플
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (1, '홍길동', '교환 가능한가요?', '4677', '2025-07-25 16:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (1, '슈퍼맨', 'AS는 가능한가요?', '9202', '2025-07-26 11:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (1, '장발장', '가격을 조금 깎아주실 수 있나요?', '2552', '2025-07-27 03:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (1, '해리포터', '추가 사진 있을까요?', '2179', '2025-07-27 01:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (1, '백설공주', '이 제품은 새 상품인가요?', '9022', '2025-07-26 22:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (7, '해리포터', 'AS는 가능한가요?', '6493', '2025-07-25 05:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (16, '신데렐라', '사용감은 어느 정도인가요?', '8002', '2025-07-25 13:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (42, '도라에몽', '제품 크기가 어떻게 되나요?', '2728', '2025-07-26 17:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (50, '홍길동', '가격을 조금 깎아주실 수 있나요?', '1574', '2025-07-25 16:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (23, '슈퍼맨', '가격을 조금 깎아주실 수 있나요?', '7281', '2025-07-25 11:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (50, '장발장', '배송은 얼마나 걸리나요?', '6960', '2025-07-25 23:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (4, '팥쥐', '배송은 얼마나 걸리나요?', '9427', '2025-07-26 20:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (42, '해리포터', '제품 크기가 어떻게 되나요?', '9536', '2025-07-24 10:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (45, '슈퍼맨', '사용감은 어느 정도인가요?', '8109', '2025-07-27 05:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (28, '해리포터', '가격을 조금 깎아주실 수 있나요?', '5181', '2025-07-27 07:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (12, '백설공주', '직거래 가능한가요?', '8782', '2025-07-26 07:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (31, '도라에몽', '직거래 가능한가요?', '7320', '2025-07-26 16:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (43, '백설공주', '사용감은 어느 정도인가요?', '2354', '2025-07-25 03:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (30, '팥쥐', '정말로 유리인가요?', '8847', '2025-07-26 09:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (2, '해리포터', 'AS는 가능한가요?', '3503', '2025-07-26 01:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (15, '신데렐라', '정말로 유리인가요?', '2338', '2025-07-27 00:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (24, '슈퍼맨', '교환 가능한가요?', '9249', '2025-07-25 18:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (26, '팥쥐', '정말로 유리인가요?', '4400', '2025-07-26 10:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (49, '홍길동', '사용감은 어느 정도인가요?', '9317', '2025-07-25 07:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (21, '홍길동', '이 제품은 새 상품인가요?', '1517', '2025-07-26 11:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (27, '해리포터', '가격을 조금 깎아주실 수 있나요?', '7301', '2025-07-25 08:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (20, '도라에몽', '정말로 유리인가요?', '3662', '2025-07-27 02:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (13, '도라에몽', '추가 사진 있을까요?', '1653', '2025-07-25 05:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (10, '슈퍼맨', '이 제품은 새 상품인가요?', '8611', '2025-07-24 15:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (7, '팥쥐', '이 제품은 새 상품인가요?', '7735', '2025-07-26 00:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (18, '신데렐라', '사용감은 어느 정도인가요?', '8143', '2025-07-26 10:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (13, '슈퍼맨', '사용감은 어느 정도인가요?', '3763', '2025-07-25 09:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (13, '해리포터', '교환 가능한가요?', '3136', '2025-07-26 19:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (45, '장발장', '사용감은 어느 정도인가요?', '6053', '2025-07-26 13:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (48, '팥쥐', '배송은 얼마나 걸리나요?', '6337', '2025-07-25 06:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (3, '백설공주', '배송은 얼마나 걸리나요?', '6992', '2025-07-26 02:30:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (13, '신데렐라', '교환 가능한가요?', '8101', '2025-07-27 07:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (10, '장발장', '가격을 조금 깎아주실 수 있나요?', '6752', '2025-07-25 10:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (12, '신데렐라', 'AS는 가능한가요?', '8257', '2025-07-24 11:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (8, '신데렐라', '이 제품은 새 상품인가요?', '7623', '2025-07-27 04:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (8, '해리포터', '배송은 얼마나 걸리나요?', '4918', '2025-07-24 08:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (35, '팥쥐', 'AS는 가능한가요?', '2276', '2025-07-24 16:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (43, '도라에몽', '이 제품은 새 상품인가요?', '2373', '2025-07-25 00:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (38, '팥쥐', '제품 크기가 어떻게 되나요?', '5852', '2025-07-26 17:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (18, '홍길동', 'AS는 가능한가요?', '6231', '2025-07-26 17:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (23, '신데렐라', '가격을 조금 깎아주실 수 있나요?', '8816', '2025-07-27 07:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (23, '신데렐라', 'AS는 가능한가요?', '8040', '2025-07-26 15:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (22, '슈퍼맨', '이 제품은 새 상품인가요?', '8999', '2025-07-26 12:46:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (4, '팥쥐', '교환 가능한가요?', '9147', '2025-07-26 17:00:00');
INSERT INTO qna (pNo, qQuestioner, qContent, qPw, qDate) VALUES (31, '신데렐라', 'AS는 가능한가요?', '5546', '2025-07-25 08:46:00');

select * from qna where pno = 1 order by qdate desc;

update product  set pMemo = "test 수정" , pPrice = 150000 where pNo = 51;

select pSeller, count(pName) from product;