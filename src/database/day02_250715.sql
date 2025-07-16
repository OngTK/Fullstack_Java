-- db day02
-- DB는 여러 개의 테이블을 저장할 수 있다.

-- [1] 데이터베이스 생성
create database mydb0715;

-- [2] DB 활서화
use mydb0715;

-- [3] 현재 활성화된 DB 안에 table 생성
-- `create table test1( 필드명·속성명 속성타입 );`
create table test1( 필드명 int );

-- [4] DB 내에 table 목록 조회
show tables;

-- 2개 이상의 속성을 정의할 경우, 쉼표(,)로 구분
create table test2( 필드명1 int , 필드명2 double );

-- [5] table 삭제
drop table test1;
drop table if exists test1;

-- [6] 데이터 타입을 이용한 table 생성
create table test3( 정수1 tinyint, 정수2 smallint, 정수3 mediumint, 정수4 int, 정수5 bigint , 정수6 int unsigned,
실수1 float, 실수2 double, 실수 decimal,
날짜 date, 시간 time, 날짜·시간 datetime,
문자1 char(3), 문자2 varchar(3), 문자3 text, 문자4 longtext, 
논리 bool);

select * from test3;

-- ex1) boardSerivce
create table board(content longtext, wirter varchar(30));
select * from board;

-- ex) waitingService
create table waiting(phone char(13), count tinyint);
select * from waiting;

-- [7] 제약조건을 이용한 테이블 설계
create table test4( 
필드1 tinyint not null, 		  -- null 대입 불가
필드2 smallint unique,  		  -- 중복값 저장 불가
필드3 int default 10,   		  -- 값 생략 시, 기본값 10이 자동 부여
필드4 bigint auto_increment,   -- 값이 생략 시 , 자동으로 순서번호 부여
constraint primary key(필드4) -- PK필드 선언
);
select * from test4;

create table test5(
필드1 bigint,
constraint foreign key(필드1) references test4(필드4)
);

-- ex3) 회원제 게시판 DB 설계
drop database if exists boardService0715;		-- 기존 DB 삭제
create database boardService0715;				-- DB 생성
use boardService0715;								-- 활성화

create table member(
mno int auto_increment,							-- 정수 + 자동번호 부여 >> PK
mID varchar(30) not null unique,				-- 최대 30글자 문자 / null·중복 불가
mPW varchar(30) not null,						-- 최대 30글자 문자 / null 불가
mname varchar(10) not null,						-- 최대 10글자 문자 / null 불가
constraint primary key(mno)						-- mno를 PK로 설정
);

select * from member;

create table board(
bno int auto_increment,							-- 정수 + 자동번호 >> pk
btitle varchar(100) not null,					-- 최대 100글자 / null 불가
bcontent longtext ,								-- 4GB 대용량 
bdate datetime default now(),					-- 날짜시간/기본값/now():현재 날짜/시간 반환
bview int default 1,                   			-- 조회수 : 기본값 1
constraint primary key(bno),
mno int, 										-- 작성자(FK)
constraint foreign key(mno) references member(mno)  -- FK 선언 참조 PK 연결
);
select * from board;