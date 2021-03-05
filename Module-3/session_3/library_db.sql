drop database ss3_library_db;
create database ss3_library_db;
use ss3_library_db;

CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);
insert into Category(category_name)
values
("Van hoc"),
("Tin hoc"),
("Ngoai ngu"),
("Toan hoc"),
("Kinh doanh");

CREATE TABLE Book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    book_title VARCHAR(50) NOT NULL,
    publisher VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    publishing_year INT NOT NULL,
    no_of_publications INT,
    price INT NOT NULL,
    image VARCHAR(50),
    category_id INT NOT NULL,
    FOREIGN KEY (category_id)
        REFERENCES Category (category_id)
);
insert into Book(book_title,publisher,author,publishing_year,no_of_publications,price,image,category_id)
values
("Tat Den", "Kim Dong", "Ngo Tat To", 1990, 5, 200000,null,1),
("Java", "Codegym", "CG", 2020,null,150000,null,2),
("English", "IDP", "Simon", 2010, null, 300000, null, 3),
("Toan lop 1", "Nhan dan","Bo giao duc", 2000, 10, 40000, null, 4),
("Donald Trump", "Da Nang","Barron Trump", 2016, null, 250000, null, 5);

CREATE TABLE Student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL,
    birthday DATE,
    address VARCHAR(500),
    email VARCHAR(50),
    phone VARCHAR(10),
    photo VARCHAR(8000)
);
insert into Student(student_name,birthday,address,email,phone,photo)
values
("NVA", null, null, null, null, null),
("NVB", null, null, null, null, null),
("NVC", null, null, null, null, null),
("NVD", null, null, null, null, null),
("NVE", null, null, null, null, null);

CREATE TABLE BorrowOrder (
    borrow_order_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    return_day DATE NOT NULL,
    status VARCHAR(15) NOT NULL,
    FOREIGN KEY (student_id)
        REFERENCES Student (student_id)
);
insert into BorrowOrder(student_id,return_day,status)
values
(1, "2021-02-01", "returned"),
(2, "2021-02-01", "returned"),
(3, "2021-02-01", "overdue"),
(4, "2021-03-01", "borrowing"),
(5, "2021-03-01", "borrowing");

CREATE TABLE OrderDetail (
    borrow_order_id INT,
    book_id INT,
    PRIMARY KEY (borrow_order_id , book_id),
    FOREIGN KEY (borrow_order_id)
        REFERENCES BorrowOrder (borrow_order_id),
    FOREIGN KEY (book_id)
        REFERENCES Book (book_id)
);
insert into OrderDetail(borrow_order_id,book_id)
values
(1, 1),
(1, 2),
(3, 4),
(4, 1),
(5, 5);

select BorrowOrder.borrow_order_id, Student.student_name, Book.book_title, Category.category_name, BorrowOrder.return_day, BorrowOrder.status
from BorrowOrder inner join OrderDetail on BorrowOrder.borrow_order_id=OrderDetail.borrow_order_id
inner join Student on BorrowOrder.student_id=Student.student_id
inner join Book on OrderDetail.book_id=Book.book_id
inner join Category on Book.category_id=Category.category_id;
