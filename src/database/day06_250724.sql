-- 1. db 생성
drop database if exists mydb0724;
create database mydb0724;
use mydb0724;

-- 2. tb 생성
create table table1(
num_pk int,
constraint primary key(num_pk));

create table table2(
no_pk int,
constraint primary key(no_pk),
num_pk int,
constraint foreign key(num_pk) references table1(num_pk) on delete cascade on update cascade);
-- table1 pk가 삭제되면 table2 fk도 삭제
-- table1 pk가 수정되면 table2 fk도 수정

-- ☆★☆★☆★☆★☆★☆★ 참조 옵션 ☆★☆★☆★☆★☆★☆★
-- on (update/delete) (cascad / set null / (restrict))
-- 1) on delete cascade : 참조중인 pk 레코드가 삭제될 경우, fk 레코드도 삭제
-- 2) on update cascade : 참조중인 pk 레코드가 변경될 경우, fk 레코드도 변경
-- 3) on delete set null : 참조중인 pk 레코드가 삭제될 경우, fk 레코드를 null로 변경
-- 4) on update set null : 참조중인 pk 레코드가 변경될 경우, fk 레코드를 null로 변경
-- 5) on delete restrict : (default) 참조중인 pk 레코드 삭제 불가
-- 6) on update restrict : (defualt) 참조중인 pk 레코드 수정 불가, 단, pk가 참조되지 않은 상태라면 수정 가능

-- 3. 서로 다른 table 합치기 = join / 집합
-- 단, 참조 관계인 table끼리만 가능!

insert into table1 values(1), (2), (3), (4), (5);
insert into table2 values(1,1), (2,2), (3,1), (4,1), (5,2);

select * from table1;
select * from table2;

-- 1) 2개 이상의 table 조회 : select * from tb1, tb2;
-- 		>> 주의 : 두 테이블 간의 곱 - 데카르트 곱 (cross join)
select * from table1, table2;

-- 2) 교집합 : 공통 값 기준 레코드 조회
-- 2-1) where ( tb1.필드 = tb2.필드 );  
-- tb1.필드 = pk / tb2.필드 = fk
-- 일반적으로 join과 조건절 국분이 어려우므로 사용하지 않음
select * from table1, table2 where table1.num_pk = table2.num_pk;

-- 2-2) inner join on
-- tb1 inner join tb2 on tb1.PK필드 = tb2.FK필드;
select * from table1 inner join table2 on table1.num_pk = table2.num_pk; 

-- ※ where : 일반조건 , Having : 그룹조건 , on : 집합조건

-- 2-3) 
-- inner 생략 가능!
select * from table1 join table2 on table1.num_pk = table2.num_pk; 
-- as 별칭 가능
select * from table1 as t1 inner join table2 t2 on t1.num_pk = t2.num_pk;
-- join 결과에서 원하는 필드만 조회 가능
select t1.num_pk 식별키, t2.num_pk 참조키 from table1 t1 inner join table2 t2 on t1.num_pk = t2.num_pk;
 
-- 2-4) natural join - 자연결합
select * from table1 natural join table2;
-- PK속성명과 FK속성명이 같을 때만 사용 가능

-- 2-5) join using
select * from table1 join table2 using(num_pk);

-- 3) outer join
-- 3-1) left outer join
-- 좌측 tb1(기준) 모든 레코드와 우측 tb2와 교집합되는 레코드 조회
-- null 레코드가 존재할 수 있음
select * from table1 t1 left outer join table2 t2 on t1.num_pk = t2.num_pk;

-- 3-2) right outer join
select * from table1 t1 right outer join table2 t2 on t1.num_pk = t2.num_pk;
-- 우측 tb2(기준) 모든 레코드와 좌측 tb1와 교집합되는 레코드 조회

-- 3-3) outer 생략 가능
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_pk;
select * from table1 t1 right join table2 t2 on t1.num_pk = t2.num_pk;

-- 4) 합집합
-- MySQL : union  / Oracle : full outer join

-- 4-1) union
-- 두 개 이상의 select를 하나로 합치기
-- left outer + UNION + right outer
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_pk union
select * from table1 t1 right join table2 t2 on t1.num_pk = t2.num_pk;


-- 5) 차집합
-- 합집합 - 교집합 = 차집합 / tb1 - (t1, t2 교집합) = 차집합
-- 5-1)	outer join where 교집합
select t1.* from table1 t1 left join table2 t2 on t1.num_pk = t2.num_pk where t2.num_pk is null;
select t2.* from table1 t1 right join table2 t2 on t1.num_pk = t2.num_pk where t1.num_pk is null;