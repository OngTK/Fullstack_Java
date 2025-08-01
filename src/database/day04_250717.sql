drop database if exists mydb0717;
create database mydb0717;
use mydb0717;

# 1. 회원테이블
create table member(            # 아이돌 그룹
   mid char(8) not null ,         # 식별키       최대 8자리
    mname varchar(10) not null ,   # 그룹명      최대 10자리
    mnumber int not null ,         # 인원수      정수 +-21억정도
    maddr char(2) not null ,       # 지역      최대 2자리
    mphone1 char(3) ,            # 지역번호   최대 2자리
    mphone2 char(8) ,            # 전화번호    최대 8자리
    mheight smallint ,            # 평균키       정수 +-3만정도
   mdebut date ,               # 데뷔일       yyyy-mm-dd
    constraint primary key ( mid )            # 제약조건
);
# 2. 구매테이블
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여
    mid char(8),                  # 구매자      FK
    bpname char(6) not null ,         # 제품명      최대 6자리
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수
    bamount smallint not null ,         # 구매수량   정수
    constraint primary key(bnum) ,               # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);

# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

select * from member;
select * from buy;

-- [1] as : 별칭, 조회 결과 grid의 속성명을 변경 (단, 원본의 속성명이 변하는 것이 아니다!)
select mid from member;
select mid as 회원아이디 from member;
select mid 회원아이디 from member;					-- as는 생략 가능
select mid as 회원아이디, mname 회원명 from member;  
select mid 회원아이디 from member as m;				-- tb명도 별칭처리 가능
select mid 회원아이디 from member m;				-- tb명도 별칭처리 가능 + as 생략

-- [2] distinct : 중복 레코드 제거
select maddr as 주소 from member;					-- 조회 결과 내의 중복 있음
select distinct maddr 주소 from member;			-- 결과 내의 중복 없음

-- [3] 산술연산자
select mnumber as 인원수 ,
mnumber +3 as 더하기 , 
mnumber -3 as 빼기 , 
mnumber *3 as 곱하기, 
mnumber /3 as 곱하기,
mnumber div 3 as 몫,
mnumber mod 3 as 나머지
from member;

-- [4] 비교연산자
-- >초과 <미만 >=이상 <=이하 =같음 !=같지않음 !not
-- beween A and B : A 이상 B 이하

select * from member where mname = "블랙핑크";
select * from member where mnumber = 4;  
select * from member where mname != '블랙핑크';
select * from member where not mname = "블랙핑크";
select * from member where mheight <= 162;

-- 논리 연산자 : and, or
-- 기타 연산자 : between, in
select * from member where mheight >= 165 and mheight <= 170;
select * from member where mheight between 165 and 170;					  	-- between A and B  
select * from member where maddr = "경기" or maddr = "전남" or maddr="경남";  	-- 조건 or 조건
select * from member where maddr in("경기","전남","경남");  					-- 조건 in (값1, 값2) = or

-- null연산자 : is null : 공란인 레코드 검색
select * from member where mphone1 = '';		-- '' 검색 불가
select * from member where mphone1 = null;		-- null 검색 불가
select * from member where mphone1 is null; 	-- is null 로 검색 가능
select * from member where mphone1 is not null; -- is not null

-- 문자 패턴 연산자 : 속성명 like `문자패턴`
select * from member where mname like '에이%';		-- % : 앞·뒤 텍스트로 시작하거나 끝나는(like 와일드카드), 자리수 상관 X		
select * from member where mname like '에이_';		-- OO_ : _는 자리수를 표현
select * from member where mname like '%핑크';
select * from member where mname like '%이%';
select * from member where mname like '__이_';
 
-- [5] 정렬 : order by 속성명 asc/desc
select * from member order by mdebut asc;
select * from member order by mdebut desc;
select * from member order by mdebut; 					-- asc/desc 생략 시 asc가 defualt로 적용
-- 정렬 기준이 2개 이상인 경우, 1차 정렬 > (1차가 동일한 레코드 내에서) 2차 정렬
select * from member order by maddr desc, mdebut asc; 	

-- [6] limit : 조회결과 레코드 수를 제한						-- pagenation에 주로 이용
select * from member limit 2;							-- 상위 2개만 제한해서 조회
select * from member limit 0,2;							-- limit A, B : A부터 B개를 출력, 주의!! record는 0부터 시작 (like index)
select * from member limit 1,5;				
select * from member order by mheight desc limit 3;