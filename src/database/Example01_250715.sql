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