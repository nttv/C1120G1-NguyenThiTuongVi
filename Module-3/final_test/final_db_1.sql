drop database module3_final_1;
create database module3_final_1;
use module3_final_1;

CREATE TABLE payment_type (
    payment_type_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_type NVARCHAR(50) NOT NULL
);

CREATE TABLE room (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    tenant_name NVARCHAR(50) NOT NULL,
    phone NVARCHAR(10) NOT NULL,
    start_date DATE NOT NULL,
    payment_type_id INT NOT NULL,
    note NVARCHAR(255),
    FOREIGN KEY (payment_type_id)
        REFERENCES payment_type (payment_type_id)
);

insert into payment_type(payment_type)
values
('Theo tháng'),
('Theo quý'),
('Theo năm');

insert into room(tenant_name, phone, start_date, payment_type_id, note)
values
('Nguyễn Văn A', '1111111111', '2021-01-01', 1, 'Phòng có điều hòa'),
('Nguyễn Văn B', '1111111111', '2021-02-01', 2, 'Phòng có điều hòa'),
('Nguyễn Văn C', '1111111111', '2021-01-01', 3, ''),
('Nguyễn Văn D', '1111111111', '2021-03-01', 1, 'Phòng có điều hòa'),
('Nguyễn Văn E', '1111111111', '2021-03-01', 1, 'Phòng có điều hòa');
