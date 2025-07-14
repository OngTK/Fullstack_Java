-- [SQL] 실습1 : 데이터베이스 관리
-- [ 문제 ] 아래 데이터베이스 관리(DDL, DCL) 관련 문제를 해결하시오.
-- [ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.

-- [문제 1] 데이터베이스 생성
-- 지시: 'my_db' 라는 이름의 새로운 데이터베이스를 생성하는 SQL 코드를 작성하시오.
create database my_db;

-- [문제 2] 데이터베이스 목록 확인
-- 지시: 현재 MySQL 서버에 존재하는 모든 데이터베이스의 목록을 확인하는 SQL 코드를 작성하시오.
show databases;

-- [문제 3] 데이터베이스 사용
-- 지시: 문제 1에서 생성한 'my_db' 데이터베이스를 사용하도록 활성화하는 SQL 코드를 작성하시오.
use my_db;

-- [문제 4] 데이터베이스 삭제
-- 지시: 'my_db' 데이터베이스를 삭제하는 SQL 코드를 작성하시오.
drop database if exists my_db;

-- [문제 5] 종합 실습
-- 지시: 아래 순서에 따라 SQL 코드를 작성하고 실행하시오.
-- 'company_db' 라는 이름의 데이터베이스가 존재하면 먼저 삭제하시오.
-- 'company_db' 라는 이름의 데이터베이스를 새로 생성하시오.
-- 'company_db' 데이터베이스를 사용하도록 활성화하시오.
-- 현재 서버의 모든 데이터베이스 목록을 다시 확인하여 'company_db'가 잘 생성되었는지 확인하시오.
drop database if exists company_db;
create database company_db;
use company_db;
show databases;