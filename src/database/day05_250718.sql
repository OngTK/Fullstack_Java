drop database if exists mydb0718;
create database mydb0718;
use mydb0718;

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

-- [1] group by 
-- 검색 결과에서 중복 값을 그룹화
-- 하나의 속성에 대해서만 그룹화 가능 (다수 속성 불가)

select bpname from buy group by bpname;
select bpname, bprice from buy group by bpname; -- 오류 발생
-- bpname의 속성값이 그룹화되더라도 bprice는 그룹화되지 않음
-- = 동일한 bpname에 대해서 bprice가 여러 개의 record가 존재하기 때문
-- ※ 여러 속성에 대해서 group by를 사용할 수 없음

-- [2] 집계·통계 함수
select bamount from buy;
select sum( bamount ) from buy; 	-- 합계
select avg( bamount ) from buy;		-- 평균
select min( bamount ) from buy; 	-- 최소
select max( bamount ) from buy; 	-- 최대
select count( bamount ) from buy; 	-- record 수, null 제외
select count( * ) from buy; 		-- record 수, null 포함

-- + group by
-- ex1. 회원아이디 별 구매수량 합계 조회
select mid, sum(bamount) from buy group by mid;

-- ex2. 회원아이디 별 총 구매금액 조회
select mid, sum(bamount * bprice) from buy group by mid;

-- ex3. 회원아이디 별 구매가격 병균 조회
select mid, sum( bprice) from buy group by mid;

-- ex4. 총 구매 횟수
select count(*) from buy;

-- ex5. 회원아이디 별 구매 횟수
select mid, count(*) from buy group by mid;

-- [3] having VS where
-- where : grouping, 집계 이전에 적용되는 조건, 별칭 불가
-- having : grouping, 집계 이후에 적용되는 조건, 별칭 가능

-- ex1. 구매수량이 3을 초과하는 회원아이디 별 레코드 조회
select mid from buy where bamount > 3;

-- ex2. 회원아이디 별 총 구매금액이 1000을 초과하는 레코드 조회
select mid, sum(bamount *bprice) from buy group by mid having sum(bamount *bprice)>=1000;
select mid, sum(bamount *bprice) as 총구매금액 from buy group by mid having 총구매금액>=1000;
select mid, sum(bamount *bprice) as 총구매금액 from buy where 총구매금액 >=1000 group by mid; -- 오류 발생!!

-- ※ 키워드 간 작성 규칙
-- select 속성명 from tb명 where 일반조건 group by 그룹속성 having 그룹조건  order by 정렬속성 asc/desc limit 갯수;
-- 처리순서 : from → where → select → group → having → order → limit
-- 일반조건절 where에서는 select에서 선언한 별칭(as)·조회를 인식하지 못함