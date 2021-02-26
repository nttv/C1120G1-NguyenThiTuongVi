create database ss2_banking_db;

use ss2_banking_db;
CREATE TABLE customers (
    customer_number INT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE accounts (
    account_number INT AUTO_INCREMENT PRIMARY KEY,
    account_type VARCHAR(20) NOT NULL,
    date DATE NOT NULL,
    balance INT NOT NULL,
    customer_number INT UNIQUE NOT NULL,
    FOREIGN KEY (customer_number)
        REFERENCES customers (customer_number),
    CHECK (account_type IN ('vip' , 'thuong', 'doanh nghiep'))
);

CREATE TABLE transactions (
    tran_number INT AUTO_INCREMENT PRIMARY KEY,
    account_number INT NOT NULL,
    date DATE NOT NULL,
    amounts INT NOT NULL,
    descriptions VARCHAR(255),
    FOREIGN KEY (account_number)
        REFERENCES accounts (account_number)
);

insert into customers (fullname, address, email, phone)
values
("NVA", "Da Nang", "abc@abc.abc", "0909000999"),
("NVB", null, "abc@abc.abc", "0909000999");

select * from customers;

delete from customers;
alter table customers auto_increment = 1;

insert into accounts (account_type, date, balance, customer_number)
values
("vip", "2020-01-01", 1000, 1),
("thuong", "2021-01-01", 0, 2);

select * from accounts;

delete from accounts;
alter table customers auto_increment = 1;