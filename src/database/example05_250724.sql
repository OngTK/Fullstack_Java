-- [SQL] 실습5 : JOIN 실습 문제
-- [ 문제 ] 아래 SQL JOIN 관련 문제를 해결하시오.
-- [ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.
-- [사전 준비] 실습용 데이터베이스 및 테이블, 데이터 생성
-- 아래 SQL 코드를 전체 복사하여 MySQL Workbench에서 실행(Ctrl+Shift+Enter)한 후 문제를 풀어주세요.
-- ==================== 실습 환경 구축 ====================
DROP DATABASE IF EXISTS exam5;
CREATE DATABASE exam5;
USE exam5;
-- 1. 카테고리 테이블
CREATE TABLE pcategory(
    카테고리번호_pk INT UNSIGNED AUTO_INCREMENT,
    카테고리명 VARCHAR(10) NOT NULL,
    PRIMARY KEY(카테고리번호_pk)
);
-- 2. 제품 테이블
CREATE TABLE product(
    제품번호_pk INT UNSIGNED AUTO_INCREMENT,
    제품명 VARCHAR(100) NOT NULL,
    제품가격 INT UNSIGNED NOT NULL,
    카테고리번호_fk INT UNSIGNED,
    PRIMARY KEY(제품번호_pk),
    FOREIGN KEY(카테고리번호_fk) REFERENCES pcategory(카테고리번호_pk)
);
-- 3. 재고 테이블
CREATE TABLE stock(
    재고번호_pk INT UNSIGNED AUTO_INCREMENT,
    재고수량 INT,
    재고등록날짜 DATETIME DEFAULT NOW(),
    제품번호_fk INT UNSIGNED,
    PRIMARY KEY(재고번호_pk),
    FOREIGN KEY(제품번호_fk) REFERENCES product(제품번호_pk)
);

-- 샘플 데이터 삽입
INSERT INTO pcategory(카테고리명) VALUES('노트북'), ('스마트폰'), ('의류'), ('도서');
INSERT INTO product(제품명, 제품가격, 카테고리번호_fk) VALUES
('그램 15인치', 1500000, 1), ('맥북 프로 16인치', 3000000, 1),
('갤럭시 S23', 1200000, 2), ('아이폰 14 Pro', 1550000, 2),
('반팔 티셔츠', 30000, 3), ('청바지', 80000, 3),
('혼공 SQL', 22000, 4);
INSERT INTO stock(재고수량, 제품번호_fk) VALUES (10, 1), (5, 2), (20, 3), (15, 4), (100, 5), (50, 6),(5, 1), (2, 3);

select * from stock;
-- ========================================================
-- [문제 1] 모든 제품의 제품명과 해당 제품의 카테고리명을 함께 조회하세요. (조회결과: 7개 레코드)

select product.제품명, pcategory.카테고리명 				 	-- 제품tb의 제품명과 카테고리tb의 카테고리명을 조회
from product inner join pcategory 					 	-- 제품tb와 카테고리 tb의 inner 교집합
on product.카테고리번호_fk = pcategory.카테고리번호_pk;	 	-- 교집합 시, 제품 tb의 카테고리fk와 카테고리 tb의 카테고리 pk가 일치

-- [문제 2] '노트북' 카테고리에 속하는 모든 제품의 제품명과 제품가격을 조회하세요. (조회결과: 2개 레코드)

select product.제품명, product.제품가격						-- 제품tb에서 제품명과 제품가격만 조회
from pcategory inner join product 						-- 카테고리tb와 제품 tb의 inner 교집합
on pcategory.카테고리번호_pk = product.카테고리번호_fk			-- 교집합 시, 두 테이블의 카테고리 번호가 일치하여야 함
where pcategory.카테고리명 = "노트북" ;						-- 조건 : 카테고리가 노트북

-- [문제 3] 모든 제품의 제품명과 등록된 재고수량을 함께 조회하세요. (조회결과: 8개 레코드)

select product.제품명, stock.재고수량 						-- 제품tb의 제품명과 재고수량을 조회
from product inner join stock							-- 제품tb와 재고tb의 inner 교집합
on product.제품번호_pk = stock.제품번호_fk;					-- 제품tb의 제품번호pk 와 재고tb의 제품번호fk가 일치해야 함	

-- [문제 4] '그램 15인치' 제품의 모든 재고등록날짜와 재고수량을 조회하세요. (조회결과: 2개 레코드)

select stock.재고등록날짜, stock.재고수량						-- 재고tb의 재고등록날짜와 재고수량을 조회
from stock inner join product							-- 재고tb와 재품tb의 inner 교집합
on product.제품번호_pk = stock.제품번호_fk					-- 제품tb의 제품번호pk 와 재고tb의 제품번호fk가 일치해야 함
where product.제품명 = "그램 15인치";						-- 제품tb의 제품명이 "그램 15인치"

-- [문제 5] 모든 제품의 제품명, 카테고리명, 재고수량을 한 번에 조회하세요. (3개 테이블 조인) (조회결과: 8개 레코드)

select product.제품명, pcategory.카테고리명, stock.재고수량	-- 제품tb의 제품명, 카테고리tb의 카테고리명, 재고tb의 재고수량을 조회
from product 											-- 제품tb에 대해서
inner join pcategory									-- 		카테고리tb를 inner 교집합
on product.카테고리번호_fk = pcategory.카테고리번호_pk			-- 			제품tb의 카테고리번호와 카테고리tb의 카테고리번호가 일치
inner join stock										-- 		재고 tb를 inner 교집합
on product.제품번호_pk = stock.제품번호_fk;					-- 			제품tb의 제품번호와 재고 제품번호가 일치

-- [문제 6] 모든 카테고리의 카테고리명과 해당 카테고리에 속한 제품명을 조회하세요. 
-- 만약 카테고리에 속한 제품이 없더라도 카테고리명은 모두 표시되도록 하세요. (조회결과: 7개 레코드)

select pcategory.카테고리명, product.제품명					-- 카테고리tb의 카테고리명과 제품tb의 제품명을 조회
from pcategory left outer join product					-- 카테고리tb와 제품tb을 좌 교집합 (null 표시를 위해) 
on pcategory.카테고리번호_pk = product.카테고리번호_fk;		-- 카테고리tb의 카테고리 번호와 제품tb의 카테고리 번호가 일치해야 함

-- [문제 7] 재고가 한 번도 등록되지 않은 제품의 제품명을 조회하세요. (조회결과: 1개 레코드)

select product.제품명										-- 제품tb의 제품명을 조회
from product left outer join stock						-- 제품tb와 재고tb를 좌 교집합 (null)
on product.제품번호_pk = stock.제품번호_fk					-- 제품tb의 제품번호와 재고tb의 재품번호가 일치해야 함
where stock.재고번호_pk is null ;							-- 단, 재고tb의 재고등록날짜가 null

-- [문제 8] 각 카테고리별로 총 재고 수량의 합계를 카테고리명과 함께 조회하세요. (조회결과: 3개 레코드)

select pcategory.카테고리명, sum(stock.재고수량)				-- 카테고리tb의 카테고리명과 재고tb의 재고수량의 SUM을 출력 
from product 											-- 제품tb에 대하여
inner join pcategory									-- 		카테고리tb을 inner join
on product.카테고리번호_fk = pcategory.카테고리번호_pk			-- 			제품tb의 카테고리번호와 카테고리tb의 카테고리번호가 일치해야 하며	
inner join stock										-- 		재고tb를 inner join
on product.제품번호_pk = stock.제품번호_fk					-- 			제품tb의 제품번호와 재고의 재품번호가 일치해야 함.
group by pcategory.카테고리번호_pk;							-- 이때, 재고수량SUM은 카테고리 번호 기준으로 진행!					

-- [문제 9] 각 제품별로 총 재고 수량을 조회하고, 총 재고 수량이 많은 순서대로 정렬하여 제품명과 총재고수량을 표시하세요. (조회결과: 6개 레코드)

select product.제품명, sum(stock.재고수량)					-- 제품tb의 제품명과 재고tb의 재고수량의 SUM을 출력
from product inner join stock							-- 제품tb와 재고tb를 inner join
on product.제품번호_pk = stock.제품번호_fk 					-- 제품tb의 제품번호와 재고tb의 제품번호가 일치할 때,
group by product.제품명 									-- 재고수량 SUM은 제품명을 기준으로 해야함
order by sum(stock.재고수량) desc;						-- 정렬은 재고수량 SUM을 기준으로 desc-내림차순으로 정렬!!

