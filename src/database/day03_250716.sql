-- 데이터베이스 조작어 / DML (Data Manipulation Language)

drop database if exists mydb0716;
create database mydb0716;
use mydb0716;

create table test(
mno int auto_increment,				-- mno / int 타입 / 자동 1 증가
mname varchar(30) not null unique,  -- mnave / 길이 30의 가변 / null 불가 / 중복불가
mcount int default 2,				-- mcount / int 타입 / 기본값 2
constraint primary key(mno)			-- mno를 PK로 선언
);



-- [1] insert : 생성
-- 레코드(테이블 내 행 단위 데이터) 삽입
-- 테이블에 데이터를 삽입할 때 단위는 **레코드**
-- insert into tb명(속성명1, 속성명2) values(값1, 값2);

insert into test(mno, mname, mcount) values(1,"유재석",30);
insert into test(mcount, mno, mname) values(40, 2 , "강호동"); 
-- 속성명 순서와 value 순서를 일치시킬 것

insert into test(mcount, mname) values(50, "신동엽"); 
-- auto_increment 제약이 적용된 mno는 값을 넣지 않아도 자동으로 1씩 증가함

insert into test(mname) value ("박명수");  
-- defalut로 인해 mcount가 기본값 2로 저장 + auto_increament
-- 입력하는 값이 1개 이므로 value 단수

-- insert into test(mno, mcount) values (5, 3)
-- ※ 오류 : mname은 기본값이 존재하지 않으므로 오류 발생

-- insert into test(mname) value ("유재석");
-- ※ 오류 : mname에는 unique 제약조건이 있으므로 동일한 mname 값을 가지는 저장시도시 오류 발생

-- 모든 속성명을 작성할 경우는 속성명 생략 가능, 단 values를 반드시 순서대로 입력
insert into test values (5,"하하",80);

-- 한 번의 insert로 여러 레코드를 삽입
insert into test values (6, "노홍철", 15) , (7, "정형돈", 30);

-- [2] select : 조회

select * from test;

-- [3] update : 수정


-- [4] delete : 삭제
