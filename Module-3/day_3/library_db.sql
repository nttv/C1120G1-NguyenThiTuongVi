create database ss3_library_db;
use ss3_library_db;

create table Book(
	book_id int auto_increment primary key,
    book_title varchar(50) not null,
    publisher varchar(50) not null,
    author varchar(50) not null,
    publishing_year int not null,
    no_of_publications int,
    price int,
    img varchar(50),
    category_id int not null,
    foreign key(category_id) references Category(category_id)
);

create table Student(
	student_number varchar(15) primary key,
    student_name varchar(50) not null,
    birthday date,
    address varchar(500),
    email varchar(50),
    phone varchar(10),
    photo varchar(8000)
);

create table Category(
	category_id int auto_increment primary key,
    category_name varchar(50) not null
);

create table BorrowOrder(
);