-- [1] 주석

# 한 줄 주석
-- 한 줄 주석
/* 여러 줄 주석 */

-- [2] SQL 명령어 작성 방법
-- 1) SQL 작성
-- 2) 문장 끝은 반드시 ;

show databases;

-- [3] SQL 명령어 실행
-- 1) 단위 실행(; 기준) : 실행할 명령문에 커서를 두고 ctrl + enter
-- 2) 전체 실행 : ctrl + shift + enter

-- [4]  결과 확인
-- 1) Result Grid : 명령에 따른 DB를 table로 표현
-- 2) Output : 에러 발생 시, 에러 문구 확인

-- [5] DB관련 주요 명령어
-- 1) show variables like 'datadir';
-- DB가 저장된 DB서버 로컬 경로 확인
show variables like 'datadir';

-- 2) DB 생성
create database mydb0714;
-- create : 생성
-- database : DB
-- mydb0714 : 저장할 DB 이름
-- 실행 후 output 확인 : 이미 만들어진 이름의 db를 또 만들면 Error 발생

-- 3) DB 삭제
drop database mydb0714;
-- drop : 버림

-- 4) DB서버 내 DB가 존재하면 삭제하기
drop database if exists mydb0714;
-- if exists :  존재하면

-- 5) DB 서버 내의 DB목록 보기
show databases;
-- information_schema / mysql / performance_schema / sys 는 defualt : 삭제금지·불가

-- 6) DB 서버 내 사용할 DB 활성화하기
-- 여러 DB 중 사용할 DB를 선택하기
use mydb0714;

-- 7) UI에서 DB 확인
-- workbench 좌측 Navigator > 새로고침 > bold처리 된 DB = 활성화된 DB

-- ex1) DB 기본 셋팅
drop database if exists test0714;   -- test0714라는 DB가 있으면 삭제
create database test0714;		    -- test0714라는 DB 생성
show databases;			  		    -- DB서버내 모든 DB 목록 보기
use test0714;					    -- DB 활성화 하기
-- 이 이후 테이블 생성, 자료 생성...