set nocount on
USE master
GO

raiserror('Creating the database....',0,1)
CREATE DATABASE Test1
GO

USE Test1
GO

create table Product
(
	Id	char(3) primary key,				
	Name	varchar(50) not null,
	UnitPrice  	money not null,
	MfgDate datetime not null /*Manufacturing Date*/
)
/*****************************************************/
-- Populating data into the tables
/********************/
insert into Product values
('001','Robby the Whale ',200.5 ,'2021/01/20'),
('002','Water Channel System ',150.25,'2020/02/25'),
('003','Parachute and Rocket ',85.5,'2020/03/30')
GO

raiserror('The database now ready for use....',0,1)
