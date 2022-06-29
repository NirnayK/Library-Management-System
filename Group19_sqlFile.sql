create database libraryManagement;
use libraryManagement;
create table book(book_id varchar(10) not null auto_increment, name varchar(40) not null, 
isbn varchar(20) not null, publisher varchar(30) not null,
 edition varchar(10) not null, 
price varchar(10) not null, pages varchar(10) not null, primary key(book_id));

create table student(student_id varchar(10) not null, name varchar(25) not null,
 father varchar(25) not null, 
course varchar(10) not null, 
branch varchar(10) not null, year varchar(10) not null, semester varchar(10) not null, primary key(student_id));

create table issueBook(book_id varchar(10) not null, student_id varchar(10) not null,
 bname varchar(40) not null, sname varchar(40) not null, course varchar(20)
  not null, branch varchar(10) not null, dateOfIssue varchar(20) not null, foreign key (book_id) references book(book_id) on delete cascade on update cascade);

create table returnBook(book_id varchar(10) not null, student_id varchar(10) not null, bname varchar(40) not null,
 sname varchar(40) not null,course varchar(20) not null, branch varchar(10) not null, dateOfIssue varchar(20) not null,
 dateOfReturn varchar(20) not null, foreign key (book_id) references book(book_id) on delete cascade on update cascade);
 
 create table account(username varchar(20) not null,
 name varchar(25) not null, password varchar(25) not null,
 sec_q varchar(25) not null, sec_ans varchar(25) not null, primary key(username));