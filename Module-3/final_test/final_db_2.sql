drop database module3_final_2;
create database module3_final_2;
use module3_final_2;

CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name NVARCHAR(50),
    price INT NOT NULL,
    discount INT NOT NULL,
    stock INT NOT NULL
);
insert into product(product_name,price,discount,stock)
values
('Iphone X',1000,10,20),
('Samsung Note 10', 1200, 5, 60),
('Samsung A5', 400,6,20),
('Iphone 10', 600,10,40),
('Iphone 8 plus 128G', 500,10,10),
('Oppo F10', 350,10,50),
('Oppo F9', 300,15,20),
('Samsung Galaxy A10', 550,20,5),
('Iphone 12', 1200,5,16),
('Xiaomi', 300,10,30);

CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name NVARCHAR(50) NOT NULL,
    emp_birthday DATE NOT NULL,
    emp_address NVARCHAR(255) NOT NULL
);
insert into employee(emp_name,emp_birthday,emp_address)
values
('Nguyễn Văn A', '1999-12-01','Vinh'),
('Nguyễn Văn B', '1998-12-01','Hue'),
('Nguyễn Văn C', '1996-12-01','Da Nang'),
('Nguyễn Văn D', '2000-12-01','Quang Nam'),
('Nguyễn Văn E', '2002-12-01','Quang Ngai'),
('Nguyễn Văn F', '2001-12-01','Da Nang'),
('Nguyễn Văn G', '1999-12-01','Da Nang'),
('Nguyễn Văn H', '2000-12-01','Da Nang'),
('Nguyễn Văn I', '2000-12-01','Hue'),
('Nguyễn Văn K', '1998-12-01','Ha Noi');

CREATE TABLE customer (
    cus_id INT AUTO_INCREMENT PRIMARY KEY,
    cus_name NVARCHAR(50) NOT NULL,
    cus_birthday DATE,
    cus_phone NVARCHAR(10) NOT NULL,
    cus_address NVARCHAR(255),
    cus_email NVARCHAR(50)
);
insert into customer(cus_name,cus_birthday,cus_phone,cus_address,cus_email)
values
("Tran Quoc Hoang",'1995-10-17',"0915682721","Quang Nam","hoang@gmail.com"),
("Nguyen Hoang Bao Ngoc",'1997-12-05',"0917949397","Quang Tri","ngoc@gmail.com"),
("Hoang Le Quang",'1993-11-23',"0902007075","Hue","quang@gmail.com"),
("Tran Hoang Sang",'1996-12-21',"0914610130","Vinh","sang@gmail.com"),
("Cai Truong Cam Van",'1998-04-05',"0919262410","Quang Tri","vancai@gmail.com"),
("Ho Ngoc Dang Khoa",'1999-08-05',"0902558286","Hue","khoa@gmail.com"),
("Nguyen Ngoc Thuan",'1998-11-30',"0908744685","Quang Tri","thuan@gmail.com"),
("Nguyen Ngoc Dong",'1985-02-01',"0909257543","Da Nang","dong@gmail.com"),
("Nguyen Thi Tuong Vi",'1992-06-03',"0917676972","Da Nang","vi.36@gmail.com"),
("Ho Nhat Long",'1999-11-08',"0916009807","Hue","long@gmail.com");

CREATE TABLE `order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_type NVARCHAR(50) NOT NULL,
    cus_id INT NOT NULL,
    emp_id INT NOT NULL,
    order_date DATE NOT NULL,
    ship_date DATE,
    ship_address NVARCHAR(50),
    FOREIGN KEY (cus_id)
        REFERENCES customer (cus_id),
    FOREIGN KEY (emp_id)
        REFERENCES employee (emp_id)
);
insert into `order`(payment_type,cus_id,emp_id,order_date,ship_date,ship_address)
values
('COD',1,4, '2021-03-03','2021-03-05','Quang Nam'),
('Banking',2,7, '2021-03-04','2021-03-06','Da Nang'),
('COD',3,5, '2021-03-05','2021-03-07','Hue'),
('COD',1,3, '2021-03-05','2021-03-07','Ho Chi Minh'),
('Visa',4,2, '2021-03-05','2021-03-06','Da Nang'),
('Banking',5,1, '2021-03-06','2021-03-07','Da Nang'),
('COD',4,8, '2021-03-06','2021-03-08','Da Nang'),
('COD',1,9, '2021-03-07',null,'Quang Ngai'),
('Banking',8,10, '2021-03-08',null,'Quang Nam'),
('Visa',9,1, '2021-03-09',null,'Ha Noi');

CREATE TABLE order_detail (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    PRIMARY KEY (order_id , product_id),
    FOREIGN KEY (order_id)
        REFERENCES `order` (order_id),
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);
insert into order_detail(order_id,product_id,quantity)
values
(1,1,1),
(2,2,1),
(3,3,2),
(4,4,3),
(4,5,1),
(4,6,1),
(5,1,1),
(6,1,2),
(7,7,1),
(7,8,2),
(8,4,1),
(9,2,2),
(10,6,1);

SELECT product.product_name, product.price, product.discount, product.stock,
 count(order_detail.product_id) as sold_quantity
from order_detail inner join `order` on order_detail.order_id = `order`.order_id
right join product on order_detail.product_id = product.product_id
group by product.product_id
order by sold_quantity desc
limit 10;

SELECT product.product_name, product.price, product.discount, product.stock
from order_detail inner join `order` on order_detail.order_id = `order`.order_id
inner join product on order_detail.product_id = product.product_id
where `order`.order_date between ? and ?
