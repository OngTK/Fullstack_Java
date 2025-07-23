drop database if exists mydb0723;
create database mydb0723;
use mydb0723;

create table user(
uno int auto_increment,
uname varchar(30) not null,
uage int default 10 ,
constraint primary key(uno) );

select * from user;

-- JDBC 매개변수 활용을 위
-- insert into user( uname, uage ) values( ? , ? );