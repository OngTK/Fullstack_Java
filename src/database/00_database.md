# MySQL_1_데이터베이스 기초

## 1. 데이터베이스·DataBase
---
### 1) 정의
자료(Data)들의 집합(Base)
### 2) 종류
#### (1) 관계형 데이터베이스
- table 형식               
- ex) oracle 등
#### (2) NOSQL 데이터베이스
- 객체 형식
- ex) mongoDB 등

### 3) 목적
- 데이터를 체계적으로 관리하기 위하여
- 데이터 중복을 최소화하고 일관성을 유지하기 위하여
- 동시 접근 및 공유를 편리하게 하기 위해
- 보안

## 2. 관계형 데이터베이스
### 1) 정의
- 행(가로)와 열(세로)로 이루어진 데이터의 집합
- 테이블(표)의 교유/식별(PK) 값을 참조하여 다른 테이블 간의 종속 관계를 표현
### 2) 소프트웨어 종류(DBMS)
Oracle, MySQL, MariaDB etc
### 3) 용어
#### (1) Database, DB
자료들의 집합
#### (2) Database Administrator, DBA
데이터베이스 관리자
#### (3) Database Management System, DBMS
데이터베이스 관리 시스템
DBA는 DBMS를 이용하여 특정한 PC의 DB를 조작한다.
#### (4) DB Server
데이터베이스가 설치된 PC
- Server : 제공자·자료를 제공하는 자
- Client : 고객·자료를 제공받는 자
#### (5) SQL
데이터베이스를 조작하기 위한 언어

---

# MySQL_2_데이터 타입
## 1. 정수
| 키워드       | byte | 특징                         |
|-----------|------|----------------------------|
| tinyint   | 1    | -128 ~ +127                |
| smallint  | 2    | ± 3만                       |
| mediumint | 3    | ± 800만                     |
| int       | 4    | ± 21억 </br> 일반적으로 가장 많이 이용 |
| bigint    | 8    | ± 21억 이상                   |
※ 타입 unsigned 
- 부호가 없는 >> 음수 범위는 삭제되고 양수 범위가 2배로 증가됨
- ex. int unsigned : + 42억

## 2. 실수
| 키워드    | byte | 특징                           |
|--------|------|------------------------------|
| float  | 4    | 소수점 8자리                      |
| double | 8    | 소수점 17자리                     |
| decimal | 문자타입 | 소수점을 문자로 처리하므로, 소수점의 누락이 없음 </br> 일반적으로 많이 이용 |

## 3. 날짜·시간
| 키워드      | 표현    | 특징                   |
|----------|-------|----------------------|
| date     | 날짜    | yyyy-MM-dd           |
| time     | 시간    | hh:mm:ss             |
| datetime | 날짜·시간 | yyyy-MM-dd hh:mm:ss  |

## 4. 문자
| 키워드         | 표현   | 특징                         |
|-------------|------|----------------------------|
| char(길이)    | 문자열  | 고정 길이,  최대 255 글자          |
| varchar(길이) | 문자열  | 가변 길이,  최대 255 글자          |
| text        | 문자열  | 최대 6만 자                    |
| longtext    | 문자열  | 최대 42억 자, 4GB 정도의 대용량 문자열  |

※ 한글의 경우, 1글자는 3byte

## 3. 논리
| 키워드    | byte | 특징                           |
|--------|------|------------------------------|
|bool| 1    | true/false|

---


# MySQL_3_SQL(Structured Query Language)
## 1. SQL 
---
### 1) 정의
- Structured Query Language
- 데이터베이스에서 데이터를 추출·조작하는데 사용되는 프로그램 언어
- 
### 2) 주요 SQL
#### (0) 메타데이터 관리어
   ① show
   - show database;                : DB 서버 내 전체 데이터베이스 목록 조회
   - show variable like 'datadir'  : DB 서버 내 local path 조회
   - show tables;                  : DB 서버 내 활성화된 tb 목록 조회
   ② use
   - use db명;                      : DB서버 내 지정한 데이터베이스 활성화

#### (1) DDL(Data Definition Language) : 정의 언어
##### ① create
- create database db명;           : DB 생성
- create table tb명(
속성명1 타입1 제약조건 1,
속성명2 타입2 );                       : table 생성

##### ② drop
- drop database db명;            : DB 삭제
- drop database if exists db명   : DB가 존재할 경우 삭제
- drop table tb명;               : tb 삭제
- drop database if exists tb명

#### (2) DML (Data Manipulation Language) : 조작 언어
##### ① insert : 생성
레코드(테이블 내 행 단위 데이터) 삽입
- insert into tb명(속성명1, 속성명2) values(값1, 값2);                   : 단일 레코드 삽입
- insert into tb명(속성명1, 속성명2) values(값1-1, 값1-2),(값2-1, 값2-2); : 복수 레코드 삽입
- 속성의 데이터 제약조건에 따라, 값 생략 가능
- 모든 values를 입력할 경우, tb명 뒤 속성명 생략 가능

##### ② select : 조회
- select * from tb명;                    : tb의 전체속성 조회
- select 속성1, 속성2 from tb명           : 해당 속성만 조회
- select 속성 from tb명 where 조건;       : 조건에 따른 결과 조회

##### ③ update : 수정
- update tb명 set 속성 = new값;             :  전체 레코드의 속성값 수정 (거의 사용X)
- update tb명 set 속성 = new값 where 조건;   : 조건에 해당하는 레코드의 속성값만 수정
- update tb명 set 속성1 = 값1 , 속성2 = 값2; : 복수 속성 수정

##### ④ delete : 삭제
- delete from tb명               : 전체 레코드 삭제
- delete from tb명 where 조건     : 조건에 해당하는 레코드 삭제

#### ※ MySQL Workbench 「Safe mode」
- MySQL에서 update·delete에 대하여 safe mode가 자동으로 실행되어 있음
- update·delete를 위해서는 safe mode off가 필요함
> safe mode on/off 방법 :
> set SQL_SAFE_UPDATES = 0 (off) / 1 (on)

#### (3) DCL (Data Control Language) : 제어 언어
_※ 추후 추가_
#### (4) TCL (Transaction Control Language) : 트랜젝션 제어 언어
_※ 추후 추가_

### 3)특징
    - SQL은 대소문자를 구분하지 않음.
    - SQL 명령어는 세미클론(;) 단위로 실행됨. 따라서 문장 끝에는 반드시 세미클론(;)이 필요

### 4) MySQL 주석
```
# 한 줄 주석
-- 한 줄 주석
/* 여러 줄 주석 */
```
---

# MySQL_4_DB생성·Table생성·속성 제약조건
## 1.DB 생성과 조작
---
### 1) 주요 DB 조작어
#### (1) 생성
`create database DB명;`
"DB명"의 DB를 생성
#### (2) 조회
`show databases;`			  		 
DB서버 내 모든 DB 목록 보기
#### (3) 활성화·사용
`use DB명;`
#### (4) 삭제
`drop database if exists DB명;`    
DB명이 기존 DB리스트에 존재할 경우, 해당 DB를 삭제

### 2) 일반적 사용
일반적으로 아래와 같이 
**삭제-생성-조회-활성화** 를 하나의 세트와 같이 사용
```
drop database if exists DB명;    -- DB명이 기존 DB리스트에 존재할 경우, 해당 DB를 삭제
create database DB명;		     -- "DB명"의 DB를 생성
show databases;			  		 -- DB서버 내 모든 DB 목록 보기
use DB명;					     -- DB 활성화 하기
```

## 2.Table 생성과 조작
---
### 1) 기본 생성 방법
※ DB활성화 주의! Table은 활성화된 DB 내에서 생성됨!

#### (1) 생성
`create table tb명( fieldName1 type1 제약조건1, fieldName2 type2 제약조건2 );`
'필드명'과 '타입'과 '제약조건'으로 이루어진 속성들로 이루어진 Table을 생성

#### (2) 조회
`show tables;`
DB 내에 table 목록 조회

#### (3) 삭제
`drop table tb명;`
tb명에 해당하는 table 삭제

`drop table if exists tb명;`
tb명이 존재할 경우, 삭제

### 2) 제약조건
테이블 내 속성에 대한 제약 조건
목적 : 테이블 데이터에 대한 문제·결함의 원인이되는 입력을 방지하기 위하여
#### (1) not null
   해당 속성에 null 값을 저장하지 않음
#### (2) unique
   해당 속성에 중복값을 허용하지 않음
#### (3) default 기본값
   값 생략시 기본값을 초기화
#### (4) auto_increment
   (MySQL) 해당 속성에 자동으로 번호 부여하며 초기화
   PK로 선언해야지만 사용 가능
#### (5) primary key (PK)
   기본키, 식별키, 식별 가능한·중복이 없는 고유 값
   not null, unique를 포함함
   선언 : `constraint primary key( PK필드명 );
#### (6) foreign key (FK)
   참조키, 외래키
   다른 테이블의 PK를 참조하는 키
   null·중복 가능
   선언 : `contraing foreign key( FK필드명 ) references 참조table명 ( 참조PK명 );`
   ※ PK필드의 속성과 FK필드의 속성은 일치해야 함☆★☆★☆★☆★☆★☆★☆★
##### ※ 참조 옵션
   선언 + `on [update/delete] [cascade / set null / (restrict)] `
   (1) on delete cascade : 참조중인 pk 레코드가 삭제될 경우, fk 레코드도 삭제
   (2) on update cascade : 참조중인 pk 레코드가 변경될 경우, fk 레코드도 변경
   (3) on delete set null : 참조중인 pk 레코드가 삭제될 경우, fk 레코드를 null로 변경
   (4) on update set null : 참조중인 pk 레코드가 변경될 경우, fk 레코드를 null로 변경
   (5) on delete restrict : (default) 참조중인 pk 레코드 삭제 불가
   (6) on update restrict : (default) 참조중인 pk 레코드 수정 불가, 단, pk가 참조되지 않은 상태라면 수정 가능

## 3. Table 생성 예
```
-- ex) 회원제 게시판 DB 설계
drop database if exists testDatabase;		-- 기존 DB 삭제
create database testDatabase;				-- DB 생성
use testDatabase;								-- 활성화

create table member(
    mno int auto_increment,							-- 정수 + 자동번호 부여 >> PK
    mID varchar(30) not null unique,				-- 최대 30글자 문자 / null·중복 불가
    mPW varchar(30) not null,						-- 최대 30글자 문자 / null 불가
    mname varchar(10) not null,						-- 최대 10글자 문자 / null 불가
    constraint primary key(mno)						-- mno를 PK로 설정
);

create table board(
    bno int auto_increment,							-- 정수 + 자동번호 >> pk
    btitle varchar(100) not null,					-- 최대 100글자 / null 불가
    bcontent longtext ,								-- 4GB 대용량 
    bdate datetime default now(),					-- 날짜시간/기본값/now():현재 날짜/시간 반환
    bview int default 1,                   			-- 조회수 : 기본값 1
    mno int, 										-- 작성자(FK)
    constraint primary key(bno),                    -- PK 선언
    constraint foreign key(mno) references member(mno)  -- FK 선언 참조 PK 연결
);
```

---

# MySQL_5_DB조작어·DML(Data Manipulation Language)

※ 가정
아래와 같은 'test' table을 생성하였다.
```
create table test(
mno int auto_increment,				-- mno / int 타입 / 자동 1 증가
mname varchar(30) not null unique,  -- mnave / 길이 30의 가변 / null 불가 / 중복불가
mcount int default 2,				-- mcount / int 타입 / 기본값 2
constraint primary key(mno)			-- mno를 PK로 선언
);
```

## 1. insert : 생성
---
레코드(테이블 내 행 단위 데이터) 삽입
- `insert into tb명(속성명1, 속성명2) values(값1, 값2);`
- 단일 레코드 삽입
- `insert into tb명(속성명1, 속성명2) values(값1-1, 값1-2),(값2-1, 값2-2);`
- 복수 레코드 삽입
- 속성의 데이터 제약조건에 따라 작성하며, 값 생략 가능
- 모든 values를 입력할 경우, tb명 뒤 속성명 생략 가능
- 속성명의 순서와 값의 순서는 일치

```
insert into test(mno, mname, mcount) values(1,"배두훈",39);

insert into test(mcount, mno, mname) values(37, 2 , "강형호"); 
-- 속성의 순서와 값의 순서를 일치시킴

insert into test(mcount, mname) values(35, "조민규"); 
-- auto_increment 제약이 적용된 mno는 값을 넣지 않아도 자동으로 1씩 증가함
-- 따라서 mno = 3으로 레코드 생성

insert into test(mname) value ("고우림");  
-- defalut로 인해 mcount가 기본값 2로 저장 + mno는 auto_increament 4로 레코드 생성

```

## 2. select : 조회
---
- `select * from tb명;`               
- tb의 전체속성 조회

- `select 속성1, 속성2 from tb명`
- 해당 속성만 조회

- `select 속성 from tb명 where 조건; `
- 조건에 따른 결과 조회

```
select * from test;
-- `속성 = *` → 전체 속성에 대해서 조회, 조회 table명은 "test"
-- test 테이블의 [ 모든 ] 속성을 조회 

select mname from test;
-- test 테이블에서 [ mname ] 속성에 대해서만 조회

select mname, mcount, mno from test;
-- test 테이블에서 [ mname, mcount, mno ] 속성을 조회

select * from test where mname="배두훈";
-- test 테이블에서 [ mname이 "배두훈" ]인 모든 속성을 조회

select * from test where mno = 3;
-- test 테이블에서 [ mno이 3 ]인 모든 속성을 조회
```
_※ 그 외 추가적인 조회 관련 키워드는 추후 설명_


## 3. update : 수정
---
- `update tb명 set 속성 = new값;`             
- 전체 레코드의 속성값 수정 (거의 사용X)

- `update tb명 set 속성 = new값 where 조건;`   
- 조건에 해당하는 레코드의 속성값만 수정

- `update tb명 set 속성1 = 값1 , 속성2 = 값2;` 
- 복수 속성 수정

```
update test set mcount =0;
-- 수정 대상 레코드를 선정하지 않았으므로 모든 레코드의 값이 수정됨
-- test 테이블에서 모든 레코드의 [ mcount 를 0 ]으로 수정

update test set mcount =10 where mname = "배두훈";
-- test 테이블에서 [ mname 이 배두훈  ]인 레코드의 [ mcount 를 10 ]으로 수정

update test set mcount =20, mname="강형호2" where mno = 2;
-- test 테이블에서 [ mno 가 2 ]인 레코드의 [ mcount 를 20 ], [ mname 을 강형호2 ]로 수정
```

## 4. delete : 삭제
---
- delete from tb명               : 전체 레코드 삭제
- delete from tb명 where 조건     : 조건에 해당하는 레코드 삭제

※ MySQL Workbench 「Safe mode」
- MySQL에서 update·delete에 대하여 safe mode가 자동으로 실행되어 있음
- update·delete를 위해서는 safe mode off가 필요함
- safe mode on/off 방법 :
    set SQL_SAFE_UPDATES = 0 (off) / 1 (on)

```
delete from test;
-- test 테이블의 전체 레코드 삭제

delete from test where mno=2;
-- test 테이블에서 [ mno 가 2 ] 레코드를 삭제
```

---


# MySQL_6_연산자·조회키워드

※ 가정
아래와 같은 'member', 'buy' table을 생성하였다.
```
# 1. 회원테이블
create table member(                # 아이돌 그룹
   mid char(8) not null ,           # 식별키       최대 8자리
    mname varchar(10) not null ,    # 그룹명       최대 10자리
    mnumber int not null ,          # 인원수       정수 +-21억정도
    maddr char(2) not null ,        # 지역         최대 2자리
    mphone1 char(3) ,               # 지역번호      최대 2자리
    mphone2 char(8) ,               # 전화번호      최대 8자리
    mheight smallint ,              # 평균키       정수 +-3만정도
   mdebut date ,                    # 데뷔일       yyyy-mm-dd
    constraint primary key ( mid )  # 제약조건
);
# 2. 구매테이블
create table buy(
   bnum int auto_increment ,        # 구매번호     정수 / 자동번호 부여
    mid char(8),                    # 구매자       FK
    bpname char(6) not null ,       # 제품명       최대 6자리
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,           # 가격        정수
    bamount smallint not null       # 구매수량     정수
    constraint primary key(bnum) ,  # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);
```

## 1. 연산자
---
### 1) 산술연산자
`+ - * / div(몫) mod(나머지)`

```
select mnumber as 인원수 ,
mnumber +3 as 더하기 , 
mnumber -3 as 빼기 , 
mnumber *3 as 곱하기, 
mnumber /3 as 곱하기,
mnumber div 3 as 몫,
mnumber mod 3 as 나머지
from member;
-- member 테이블에서 mnumber 속성에 대해 연산을 수행하여 출력
```

### 2) 비교연산자
`>초과 <미만 >=이상 <=이하 =같음 !=같지않음 !not`

```
select * from member where mname = "블랙핑크";
select * from member where mnumber = 4;  
select * from member where mname != '블랙핑크';
select * from member where not mname = "블랙핑크";
select * from member where mheight <= 162;
```


### 3) 논리 연산자
and or

### 4) 기타 연사자
- between A and B
    - A~B 값을 조회
    - A 이상 B 이하
- in (A, B)
  - = A or B
```
select * from member where mheight >= 165 and mheight <= 170;
select * from member where mheight between 165 and 170;					  	-- between A and B  
select * from member where maddr = "경기" or maddr = "전남" or maddr="경남";  	-- 조건 or 조건
select * from member where maddr in("경기","전남","경남");  					-- 조건 in (값1, 값2) = or
```

### 5) null연산자 : is null
- 공란인 레코드
```
select * from member where mphone1 = '';		-- '' 검색 불가
select * from member where mphone1 = null;		-- null 검색 불가
select * from member where mphone1 is null; 	-- is null 로 검색 가능
select * from member where mphone1 is not null; -- is not null
```


### 6) 문자패턴 연산자
속성명 like '문자패턴'
% : 와일드카드 *같은 역할, 자리수 상관 없음
_ : 값은 모르는 자리수 1개를 의미
```
ex. '김%' = '김'으로 시작하는 문자
'%다' = '다'로 끝나는 문자
'이_' = '이'로 시작하고, '이' 뒤에 1글자만 존재하는 문자
'_동' = '동'으로 끝나고, '동' 앞에 1글자만 존재하는 문자
```

```
select * from member where mname like '에이%';		-- % : 앞·뒤 텍스트로 시작하거나 끝나는(like 와일드카드), 자리수 상관 X		
select * from member where mname like '에이_';		-- OO_ : _는 자리수를 표현
select * from member where mname like '%핑크';
select * from member where mname like '%이%';
select * from member where mname like '__이_';
```

## 2. 조회 관련 키워드
---
#### 1) as 별칭
- 조회 결과 grid에 표시될 속성명을 변경
- 원본 tb의 속성이 변경되는 것이 아님

```
select mid as 회원아이디 from member;
select mid 회원아이디 from member;					-- as는 생략 가능
-- member 테이블에서 mid 속성에 대해서 조회 
-- 단, 결과 그리드에 [ mid를 "회원 아이디"]로 표시

select mid as 회원아이디, mname 회원명 from member;  
select mid 회원아이디 from member as m;		    -- tb명도 별칭처리 가능
select mid 회원아이디 from member m;				-- tb명도 별칭처리 가능 + as 생략
-- m 이라는 별칭의 member 테이블에서, mid를 회원아이디로 표기하여 mid 속성에 대해서 조회
```

#### 2) distinct
- 중복 레코드 제거
```
select distinct maddr 주소 from member;			-- 결과 내의 중복 없음
-- member 테이블에서 maddr에 대해 중복 레코드를 제외하고 조회
-- 단, maddr를 grid에 "주소"로 표시
```

#### 3) order by
- 정렬
- order by 속성명 asc  : 오름차수 정렬
- order by 속성명 desc : 내림차수 정렬
```
select * from member order by mdebut asc;
select * from member order by mdebut desc;
select * from member order by mdebut; 					-- asc/desc 생략 시 asc가 defualt로 적용
-- 정렬 기준이 2개 이상인 경우, 1차 정렬 > (1차가 동일한 레코드 내에서) 2차 정렬
select * from member order by maddr desc, mdebut asc; 	
```

#### 4) limit
- 조회결과 레코드 수를 제한
- limit x : 상위 x개를 조회
- limit x, y : x번 record부터 y개를 조회 (※ record는 0부터 시작)
```
select * from member limit 2;							-- 상위 2개만 제한해서 조회
select * from member limit 0,2;							-- limit A, B : A부터 B개를 출력, 주의!! record는 0부터 시작 (like index)
select * from member limit 1,5;				
select * from member order by mheight desc limit 3;
```


# MySQL_7_그룹·통계

※ 가정
아래와 같은 'member', 'buy' table을 생성하였다.
```
# 1. 회원테이블
create table member(                # 아이돌 그룹
   mid char(8) not null ,           # 식별키       최대 8자리
    mname varchar(10) not null ,    # 그룹명       최대 10자리
    mnumber int not null ,          # 인원수       정수 +-21억정도
    maddr char(2) not null ,        # 지역         최대 2자리
    mphone1 char(3) ,               # 지역번호      최대 2자리
    mphone2 char(8) ,               # 전화번호      최대 8자리
    mheight smallint ,              # 평균키       정수 +-3만정도
   mdebut date ,                    # 데뷔일       yyyy-mm-dd
    constraint primary key ( mid )  # 제약조건
);
# 2. 구매테이블
create table buy(
   bnum int auto_increment ,        # 구매번호     정수 / 자동번호 부여
    mid char(8),                    # 구매자       FK
    bpname char(6) not null ,       # 제품명       최대 6자리
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,           # 가격        정수
    bamount smallint not null       # 구매수량     정수
    constraint primary key(bnum) ,  # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);
```

## 1. 그룹·통계
---
### 1) group by
- 검색 결과에서 중복 값을 그룹화
- 하나의 속성에 대해서만 그룹화 가능 (다수 속성 불가)
```
select bpname from buy group by bpname;

select bpname, bprice from buy group by bpname; -- 오류 발생
-- bpname의 속성값이 그룹화되더라도 bprice는 그룹화되지 않음
-- = 동일한 bpname에 대해서 bprice가 여러 개의 record가 존재하기 때문
-- ※ 여러 속성에 대해서 group by를 사용할 수 없음
```

### 2) 집계·통계 함수
sum( 속성명 )
avg( 속성명 )
min( 속성명 )
max( 속성명 )
count( 속성명 ) : 속성명에 해당하는 record 수, null 제외
count( * )     : record 수, null 포함
```
select bamount from buy;
select sum( bamount ) from buy; 	-- 합계
select avg( bamount ) from buy;		-- 평균
select min( bamount ) from buy; 	-- 최소
select max( bamount ) from buy; 	-- 최대
select count( bamount ) from buy; 	-- record 수, null 제외
select count( * ) from buy; 		-- record 수, null 포함
```

```
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
```

### 3) having
- grouping·집계 이후에 적용되는 조건, 별칭 가능
- vs where : grouping·집계 이전에 적용되는 조건, 별칭 불가
```
-- ex1. 구매수량이 3을 초과하는 회원아이디 별 레코드 조회
select mid from buy where bamount > 3;

-- ex2. 회원아이디 별 총 구매금액이 1000을 초과하는 레코드 조회
select mid, sum(bamount *bprice) from buy group by mid having sum(bamount *bprice)>=1000;
select mid, sum(bamount *bprice) as 총구매금액 from buy group by mid having 총구매금액>=1000;
select mid, sum(bamount *bprice) as 총구매금액 from buy where 총구매금액 >=1000 group by mid; -- 오류 발생!!
```

# MySQL_8_Join·집합
참조 관계(PK-FK)인 table 사이에서만 가능!

### 1) 2개 이상의 table 결합하여 조회
`select * from tb1, tb2;`
※ 주의 : 두 테이블 간의 곱 - 데카르트 곱 (cross join) >> 거의 안씀

### 2) 교집합
#### (1) where
`select * from tb1, tb2 where ( tb1.PK필드 = tb2.FK필드 );`
- 일반적으로 join과 조건절 국분이 어려우므로 사용하지 않음

#### (2) inner join on ☆★☆★☆★☆★☆★
`select * from tb1 inner join tb2 on tb1.PK필드 = tb2.FK필드;`
- inner 생략 가능
- tb명 + as 로 별칭 가능
- select (조건) 에 `tb1.필드` 형태로 원하는 필드만 조회 가능

#### (3) natural join
`select * from tb1 natural join tb2;`
- PK필드명과 FK필드명이 같을 때만, 사용 가능
- join 의도와 상관없이 동일한 필드명이 존재할 수 있으므로, 사용을 권장하지는 않음

#### (4) join using
`select * from tb1 join tb2 using(pk필드명);`
- PK필드명과 FK필드명이 같을 때만, 사용 가능
- join 의도와 상관없이 동일한 필드명이 존재할 수 있으므로, 사용을 권장하지는 않음

#### (5) outter join
##### ① left outer join
`select * from tb1 left outer join tb on tb1.pk = tb2.fk;`
- 좌측 tb1(기준) 모든 레코드와 우측 tb2와 교집합되는 레코드 조회
- null 레코드가 존재할 수 있음
##### ② right outer join
`select * from tb1 right outer join tb on tb1.pk = tb2.fk;`
- 우측 tb2(기준) 모든 레코드와 좌측 tb1와 교집합되는 레코드 조회
##### ③ outer 생략 가능
`select * from tb1 left join tb on tb1.pk = tb2.fk;`
`select * from tb1 right join tb on tb1.pk = tb2.fk;`

### 3) 합집합
MySQL : union  / Oracle : full outer join

#### (1) union
- 두 개 이상의 select를 하나로 합치기
- left outer + UNION + right outer

### 4) 차집합
- 합집합 - 교집합 = 차집합
- tb1 - (t1, t2 교집합) = 차집합

#### (1) outer join where 교집합
```sql
select tb1.* from tb1 left join tb2 on tb1.pk = tb2.fk where tb2.fk is null;
                | tb1 PK(좌)에 대해서 tb2 FK(우) 교집합 조회|
                                                         | tb2 null >> 교집합이 아닌 부분에 대한 조건|
| tb1의 모든 속성을 조회 |

select tb2.* from tb1 right join tb2 on tb1.pk = tb2.fk where tb1.pk is null;
                | tb2 FK(우)에 대해서 tb2 PK(좌) 교집합 조회|
                                                         | tb1 null >> 교집합이 아닌 부분에 대한 조건|
| tb2의 모든 속성을 조회 |
```