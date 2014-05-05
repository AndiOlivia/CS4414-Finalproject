
-- DROP database homeManagerDB;

-- CREATE DATABASE homeManagerDB; 
use homemanagerdb;
--1 product type table
create table productType(
	ptName char(50) primary key,			
	ptBrief char(100)						
);

insert productType values('Food','Food type');
insert productType values('Clothing','Clothing type');
insert productType values('Beauty & Care','Beauty & Care type');
insert productType values('Appliance','Appliance type');
insert productType values('Electronics & Computers','Electronics & Computers type');
insert productType values('Automotive','Automotive type');


--2 product table
-- drop table product;
create table product(
	pdtNo varchar(12),
	pdtName varchar(100) ,
	pdtType varchar(50),						
	pdtFactory varchar(50),						
	pdtPrice float,						
	pdtTel varchar(15),					
	pdtAddr varchar(50),				
	pdtLinkMan varchar(12),				
	pdtComment varchar(100),
	constraint PK_PRODUCT primary key(pdtNo)
);

--delete from product where pdtno=0000007; 
insert into product(pdtno,pdtName,pdtType) values('0000001','Bread','Food');
insert into product(pdtno,pdtName,pdtType) values('0000002','Shirt','Clothing');
insert into product(pdtno,pdtName,pdtType) values('0000003','Shampoo','Beauty & Care');
insert into product(pdtno,pdtName,pdtType) values('0000004','Vacuum Cleaner','Appliance');
insert into product(pdtno,pdtName,pdtType) values('0000005','Computer','Electronics & Computers');
insert into product(pdtno,pdtName,pdtType) values('0000006','Mat','Automotive');


-- drop table user;

create table user(
username varchar(24) primary key,  
password varchar(16),  --
id char(18), 
tel char(15),
mobile char(12),
province char(20),
city char(10),
addr varchar(40),
postCode char(30),
state tinyint,   
t1 varchar(40) , 
t2 varchar(20)
);
-- alter table user add t1 varchar(40);
-- alter table user add t2 varchar(20);

-- delete from user;
insert into user(username,password,state) values('Andi','0000',1);
insert into user(username,password,state) values('Huiqing','0000',1);

insert into user(username,password,state) values('zhangming','0000',1);
insert into user(username,password,state) values('liming','0000',1);


create table Fee(
	feeNo int auto_increment,
	feePdtId varchar(12),
	feePdtName varchar(50),
	feeAmount float,
	feePrice float,
	feeTotalPrice float,
	feeDate date,
	feeComment varchar(100),
	constraint PK_Fee primary key(feeNo)
);

-- drop table grouptable;

create table grouptable(
groupname varchar(30) primary key,  
groupdesc varchar(20)
); 
insert into grouptable() VALUES('ClientOp','Client Operator');
insert into grouptable() VALUES('Super','Super administrator');

-- drop table usergroup;

CREATE table usergroup(
username varchar(16) REFERENCES user(username),
groupname varchar(30) references grouptable(groupname),
primary key(username,groupname)
);

INSERT into usergroup() values('Huiqing','ClientOp');
INSERT into usergroup() values('Andi','Super');

-- drop table privilege;

SELECT * FROM user WHERE username = 'Andi' and password='0000' and state=1	

create table privilege(
	privilegename varchar(30) primary key, 
	privilegedesc varchar(50)  
);

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES 
('UserMgrPrivilege',''),
('PdtTypeSelectPrivilge',''),
('PdtTypeInsertPrivilge',''),
('PdtTypeDelPrivilge',''),
('PdtTypeUpdatePrivilge',''),
('PdtSelectPrivilge',''),
('PdtInsertPrivilge',''),
('PdtDelPrivilge',''),
('PdtUpdatePrivilge',''),
('MercSelectPrivilge',''),
('MercInsertPrivilge',''),
('MercDelPrivilge',''),
('MercUpdatePrivilge',''),
('SuperPrivilge','')
;

INSERT INTO `privilege` VALUES ('SuperPrivilege','Super Privilege');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;


-- drop table groupprivilege;

create TABLE groupprivilege(
groupname varchar(30) references grouptable(groupname),
privilegename varchar(30)references privilege(privilegename),
primary key(groupname,privilegename)
);

-- delete from groupprivilege;
INSERT into groupprivilege() values('UserMgrGroup','');
INSERT into groupprivilege() values('familyGroup','SuperPrivilege');
INSERT into groupprivilege() values('SelfGroup','Product group');
INSERT into groupprivilege() values('Guest','Guest');
INSERT into groupprivilege() values('Super','SuperPrivilege');

insert groupprivilege values('UserMgrGroup','UserMgrPrivilege');
insert groupprivilege values('familyGroup','PdtTypeSelectPrivilege');
insert groupprivilege values('familyGroup','PdtTypeInsertPrivilege');
insert groupprivilege values('familyGroup','PdtTypeDelPrivilege');
insert groupprivilege values('familyGroup','PdtTypeUpdatePrivilege');
insert groupprivilege values('familyGroup','PdtSelectPrivilege');
insert groupprivilege values('familyGroup','PdtInsertPrivilege');
insert groupprivilege values('familyGroup','PdtDelPrivilege');
insert groupprivilege values('familyGroup','PdtUpdatePrivilege');
INSERT into groupprivilege() values('selfGroup','MercSelectPrivilege');
INSERT into groupprivilege() values('selfGroup','MercInsertPrivilege');
INSERT into groupprivilege() values('selfGroup','MercDelPrivilege');
INSERT into groupprivilege() values('selfGroup','MercUpdatePrivilege');
INSERT into groupprivilege() values('guest','PdtTypeSelectPrivilege');
INSERT into groupprivilege() values('guest','PdtSelectPrivilege');


--------------------------------------------------------------------------------------------New user data
delete from privilege;
INSERT INTO `privilege` VALUES 
('UserMgrPrivilege',''),
('PdtTypeSelectPrivilge',''),
('PdtTypeInsertPrivilge',''),
('PdtTypeDelPrivilge',''),
('PdtTypeUpdatePrivilge',''),
('PdtSelectPrivilge',''),
('PdtInsertPrivilge',''),
('PdtDelPrivilge',''),
('PdtUpdatePrivilge',''),
('MercSelectPrivilge',''),
('MercInsertPrivilge',''),
('MercDelPrivilge',''),
('MercUpdatePrivilge',''),
('SuperPrivilge','')
;


delete from grouptable;
insert into grouptable() VALUES('Super','');
insert into grouptable() VALUES('UserMgrGroup','');
insert into grouptable() VALUES('FamilyGroup','');
insert into grouptable() VALUES('HostGroup','');
INSERT into grouptable() values('Guests','Guest group');

delete from groupprivilege;
insert groupprivilege values('UserMgrGroup','UserMgrPrivilege');
insert groupprivilege values('FamilyGroup','PdtTypeSelectPrivilege');
insert groupprivilege values('FamilyGroup','PdtTypeInsertPrivilege');
insert groupprivilege values('FamilyGroup','PdtTypeDelPrivilege');
insert groupprivilege values('FamilyGroup','PdtTypeUpdatePrivilege');
insert groupprivilege values('FamilyGroup','PdtSelectPrivilege');
insert groupprivilege values('FamilyGroup','PdtInsertPrivilege');
insert groupprivilege values('FamilyGroup','PdtDelPrivilege');
insert groupprivilege values('FamilyGroup','PdtUpdatePrivilege');
INSERT into groupprivilege() values('HostGroup','MercSelectPrivilege');
INSERT into groupprivilege() values('HostGroup','MercInsertPrivilege');
INSERT into groupprivilege() values('HostGroup','MercDelPrivilege');
INSERT into groupprivilege() values('HostGroup','MercUpdatePrivilege');
INSERT into groupprivilege() values('Guests','PdtTypeSelectPrivilege');
INSERT into groupprivilege() values('Guests','PdtSelectPrivilege');
INSERT into groupprivilege() values('Super','SuperPrivilege');

delete from user;
insert into user(username,password,state) values('Andi','0000',1);
insert into user(username,password,state) values('Huiqing','0000',1);
insert into user(username,password,state) values('zhangming','0000',1);
insert into user(username,password,state) values('liming','0000',1);
insert into user(username,password,state) values('wangming','0000',1);


delete from usergroup;
INSERT into usergroup() values('Andi','Super');
INSERT into usergroup() values('wangming','FamilyGroup');
INSERT into usergroup() values('wangming','HostGroup');
INSERT into usergroup() values('zhangming','FamilyGroup');
INSERT into usergroup() values('Huiqing','Guests');



