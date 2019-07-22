create database db;
use db;
create table author(authorid int(6) not null, firstname varchar(10), middlename varchar(10), lastname varchar(10),phonenumber numeric(10));
desc author;
select * from author;