drop database if exists waiting;
create database waiting;
use waiting;

create table waiting(
phone varchar(15) not null,
count tinyint unsigned);

select*from waiting;