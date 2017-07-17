
-- import sql using XAMPP
use  databasename
source db.sql;

create database Bank;
use bank;

create table Customer (
c_id varchar(10) primary key,
cname varchar(20) not null,
mno int,
address varchar(30),
city varchar(10)
);

ALTER TABLE Customer
ADD DOB varchar(20);

alter table Customer
modify address varchar(20);


insert into Customer values ('C1','Ankur',838289,'Domlur','Bangalore','11-Sep-1990');
insert into Customer values ('C2','John',89849,'Vaishali','Jaipur','10-Oct-1992');
insert into Customer values ('C3','Raman',888950,'Marathali','bangalore','15-Aug-1987');

update  Customer 
set city='Bangalore' where c_id='C2';

delete from Customer where c_id='C3';


create table Account (acct_no varchar(10),
c_id varchar(10),
type varchar (10),
balance int ,
FOREIGN KEY (c_id) REFERENCES Customer(c_id)
);


insert into Account values('CA1','C1','Savings',50000);
insert into Account values('CA2','C1','Savings',10000);


Select cname from Customer 
group by cname
having count(*) >2;


Select * from Customer 
group by cname;


Select * from Customer 
order by cname asc;

truncate table Customer;
RENAME TABLE  `Account` TO  `Customer_Account`;
drop table Customer;
drop table Customer_Account;


