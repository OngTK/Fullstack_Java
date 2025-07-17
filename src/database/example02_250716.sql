drop database if exists example02;
create database example02;
use example02;

-- [SQL] 실습2 : SQL 실습 문제 ( DML )
-- [ 문제 ] 아래 SQL 실습 문제 ( DML ) 관련 문제를 해결하시오.
-- [ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.

-- [문제 1] 아래 조건에 맞는 members 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: members
-- 컬럼 정보:
-- member_id (회원 아이디): 문자열(20), 기본 키(Primary Key), NULL 허용 안함
-- member_name (회원 이름): 문자열(50), NULL 허용 안함
-- email (이메일): 문자열(100), 고유 키(Unique), NULL 허용 안함
-- join_date (가입일): 날짜/시간, **기본값(Default)**은 현재 날짜/시간
-- points (포인트): 정수, **기본값(Default)**은 0

drop table if exists members;
create table members(
member_id varchar(20) not null,   	-- PK는 not null이 기본값이므로 생략해도 가능, 다만 착오가 없도록 명시해주는 것을 추천
member_name varchar(50) not null,
email varchar(100) unique not null,
join_date datetime default now(),
points int default 0,
constraint primary key(member_id)
);
select * from members;

-- [문제 2] members 테이블에 아래 정보를 가진 새로운 회원을 추가하는 SQL을 작성하세요.
-- member_id: 'user01'
-- member_name: '김철수'
-- email: 'chulsoo@example.com'
-- points: 1000
insert into members(member_id, member_name , email , points) values ("user01" ,"김철수","chulsoo@example.com",1000);

-- [문제 3]members 테이블에서 모든 회원의 member_id와 email을 조회하는 SQL을 작성하세요.
select member_id, email from members;

-- [문제 4]members 테이블에서 member_id가 'user01'인 회원의 points를 1500으로 업데이트하는 SQL을 작성하세요.
update members set points=1500 where member_id = "user01";  

-- [문제 5]members 테이블에서 member_id가 'user01'인 회원을 삭제하는 SQL을 작성하세요.
delete from members where member_id="user01";

-- [문제 6] 아래 조건에 맞는 products 테이블을 생성하는 SQL을 작성하세요.
-- 테이블명: products
-- 컬럼 정보:
-- product_code (상품 코드): 정수, 기본 키(Primary Key), 1씩 자동 증가
-- product_name (상품명): 문자열(100), NULL 허용 안함
-- price (가격): 정수, unsigned, NULL 허용 안함
-- stock_quantity (재고 수량): 정수, NULL 허용 안함, **기본값(Default)**은 0
-- category (카테고리): 문자열(50)
drop table if exists products;
create table products(
product_code int auto_increment,
product_name varchar(100) not null,
price int unsigned not null,
stock_quantity int not null default 0,
category varchar(50),
constraint primary key(product_code)
);
select * from products;

-- [문제 7] products 테이블에 아래 정보를 가진 새로운 상품을 추가하는 SQL을 작성하세요.
-- product_name: '프리미엄 키보드'
-- price: 120000
-- stock_quantity: 50
-- category: '컴퓨터 주변기기'
insert into products(product_name , price , stock_quantity, category) values ("프리미엄 키보드",120000 , 50,"컴퓨터 주변기기" );

-- [문제 8] products 테이블에서 category가 '컴퓨터 주변기기'인 상품의 product_name과 price를 조회하는 SQL을 작성하세요.
select product_name, price from products where category="컴퓨터 주변기기";

-- [문제 9] products 테이블에서 product_name이 '프리미엄 키보드'인 상품의 stock_quantity를 45로 업데이트하는 SQL을 작성하세요.
update products set stock_quantity = 45 where product_name= '프리미엄 키보드';

-- [문제 10] products 테이블에서 product_name이 '프리미엄 키보드'인 상품을 삭제하는 SQL을 작성하세요.
delete from products where product_name='프리미엄 키보드';

