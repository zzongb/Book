--创建管理员表
create table tbl_user(
	id number,
	username varchar2(20),
	password varchar2(20),
	status number,
	constraint tbl_user_id_pk primary key(id),
	constraint tbl_user_un_ck check(username is not null),
	constraint tbl_user_ps_ck check(password is not null),
	constraint tbl_user_st_ck check(status is not null)
)
create sequence tbl_book_id;

--创建用户表
create table tbl_student(
	id number,
	suser varchar2(20),
	spassword varchar2(20),
	grade varchar2(30),
	major varchar2(20),
	status number,
	constraint tbl_student_id_pk primary key(id),
	constraint tbl_student_un_ck check(suser is not null),
	constraint tbl_studnet_ps_ck check(spassword is not null),
	constraint tbl_studnet_st_ck check(status is not null)
)
crate sequence tbl_student_id;

--创建图书表
create table tbl_book(
	id number,
	isbn varchar2(20),
	bname varchar2(20),
	author varchar2(20),
	price number(5,2),
	publishhouse varchar2(30),
	publishDate date,
	info varchar2(255),
	num number,
	balance number,
	type varchar2(20),
	constraint tbl_book_id_pk primary key(id)
)

create sequence tbl_book_id;


--创建借书表
create table borrow(
 	id number,
 	borrowDate date,
 	returnBook date,
 	sid number,
 	bid number,
 	
 	constraint tbl_borrow_id_pk primary key(id),
 	constraint tbl_borrow_sid_fk foreign key(sid)
 	references tbl_student(id),
 	constraint tbl_borrow_bid_fk foreign key(bid)
 	references tbl_book(id)
)

create sequence tbl_borrow_id;


