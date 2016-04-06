drop table UserData
drop table DepartmentData 
drop table MessageData  
drop table ContactData
drop table PersonScheData
drop table DepScheData 
drop table CompScheData 
drop table DepNoticeData 
drop table CompNoticeData
drop table ChattingData 

CREATE TABLE UserData(
id VARCHAR2(10) UNIQUE,
passwd VARCHAR2(20) NOT NULL,
name VARCHAR2(10) NOT NULL,
socialNumPre NUMBER NOT NULL,
socialNumPost NUMBER NOT NULL,
email VARCHAR2(30) UNIQUE,
phoneNum NUMBER UNIQUE,
depNum NUMBER,
Permission NUMBER,
userNum NUMBER,
loginFlag CHAR(1),
currentStatus CHAR(1),
CONSTRAINT PK_UserData PRIMARY KEY(userNum)
)
CREATE SEQUENCE UserData_seq;

alter table UserData drop constraint FK_depNum;
alter table DepartmentData drop constraint FK_userNum;

ALTER TABLE UserData
add CONSTRAINT FK_depNum FOREIGN KEY(userNum)
REFERENCES DepartmentData(depNum);

CREATE TABLE DepartmentData(
depNum NUMBER,
depName VARCHAR2(10) UNIQUE,
depPhoneNum NUMBER UNIQUE,
userNum NUMBER
)
ALTER TABLE DepartmentData 
ADD CONSTRAINT PK_Department PRIMARY KEY(depNum);

ALTER TABLE DepartmentData
ADD CONSTRAINT FK_userNum FOREIGN KEY(userNum)
REFERENCES userData(userNum);

/*여까지 사원테이블이랑 부서테이블*/

CREATE TABLE MessageData(
messageNum NUMBER NOT NULL,
senderUserNum NUMBER NOT NULL,
receiverUserNum NUMBER NOT NULL,
messageContent VARCHAR2(400) NOT NULL,
messageDate TIMESTAMP not null,
CONSTRAINT PK_MessageData PRIMARY KEY(messageNum),
CONSTRAINT FK_senderUserNum FOREIGN KEY(senderUserNum)
REFERENCES userData(userNum)
)
CREATE SEQUENCE MessageData_seq;

ALTER TABLE MessageData
ADD CONSTRAINT FK_receiverUserNum FOREIGN KEY(receiverUserNum)
REFERENCES userData(userNum)
/*메세지 끝! 데헹*/

create table ContactData(
contactNum number not null,
depNum number not null,
userNum number not null,
constraint PK_ContactData primary key(contactNum),
constraint ContactData_FK_depNum foreign key(depNum)
references DepartmentData(depNum),
constraint ContactData_FK_userNum foreign key(userNum)
references UserData(userNum)
)

CREATE SEQUENCE ContactData_seq;

create table PersonScheData(
userScheNum number not null,
userNum number not null,
userScheContent varchar2(400),
userScheDate timestamp not null,
constraint PK_PersonScheData primary key(userScheNum),
constraint PersonScheData_FK_userNum foreign key(userNum)
references UserData(userNum)
)

CREATE SEQUENCE PersonScheData_seq;

create table DepScheData(
depScheNum number not null,
depNum number not null,
userNum number not null,
depScheContent varchar2(400),
depScheDate timestamp not null,
constraint PK_DepScheData primary key(depScheNum),
constraint DepScheData_FK_depNum foreign key(depNum)
references DepartmentData(depNum)
)

CREATE SEQUENCE DepScheData_seq;

alter table DepScheData
add constraint DepScheData_FK_userNum foreign key(userNum)
references UserData(userNum)

create table CompScheData(
compScheNum number not null,
userNum number not null,
compScheContent varchar2(400),
compScheDate timestamp not null,
constraint PK_CompScheData primary key(compScheNum),
constraint CompSche_FK_userNum foreign key(userNum)
references UserData(userNum)
)

CREATE SEQUENCE CompScheData_seq;

create table DepNoticeData(
depNoticeNum number not null,
depNum number not null,
userNum number not null,
depNoticeTitle varchar2(20) not null,
depNoticeContent varchar2(400) not null,
depNoticeDate timestamp not null,
constraint PK_DepNoticeDate primary key(depNoticeNum),
constraint DepNoticeData_FK_depNum foreign key(depNum)
references DepartmentData(depNum),
constraint DepNoticeData_FK_userNum foreign key(userNum)
references UserData(userNum)
)

CREATE SEQUENCE DepNoticeData_seq;

create table CompNoticeData(
compNoticeNum number not null,
userNum number not null,
compNoticeTitle varchar2(20) not null,
compNoticeContent varchar2(400) not null,
compNoticeDate timestamp not null,
constraint PK_CompNoticeData primary key(compNoticeNum),
constraint CompNoticeData_FK_userNum foreign key(userNum)
references UserData(userNum)
)
CREATE SEQUENCE CompNoticeData_seq;

create table ChattingData(
chattingNum number not null,
depNum number not null,
userNum number not null,
chattingContent varchar2(200),
constraint PK_ChattingData primary key(chattingNum),
constraint ChattingData_FK_depNum foreign key(depNum)
references DepartmentData(depNum),
constraint ChattingData_FK_userNum foreign key(userNum)
references UserData(userNum)
)
CREATE SEQUENCE ChattingData_seq;