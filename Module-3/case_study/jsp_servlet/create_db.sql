drop database cs_furama_db;
create database cs_furama_db;
use cs_furama_db;

CREATE TABLE position (
    position_id INT AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(45) NOT NULL
);
CREATE TABLE education_degree (
    education_degree_id INT AUTO_INCREMENT PRIMARY KEY,
    education_degree_name VARCHAR(45) NOT NULL
);
CREATE TABLE division (
    division_id INT AUTO_INCREMENT PRIMARY KEY,
    division_name VARCHAR(45) NOT NULL
);
CREATE TABLE `role` (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);
CREATE TABLE `user` (
    username VARCHAR(255) PRIMARY KEY,
    `password` VARCHAR(255) NOT NULL
);
CREATE TABLE user_role (
    role_id INT,
    username VARCHAR(255),
    PRIMARY KEY (role_id , username),
    FOREIGN KEY (role_id)
        REFERENCES `role` (role_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (username)
        REFERENCES `user` (username)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE employee (
    employee_id VARCHAR(45) PRIMARY KEY,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE NOT NULL,
    employee_id_card VARCHAR(45) NOT NULL UNIQUE,
    employee_salary DOUBLE NOT NULL,
    employee_phone VARCHAR(45) NOT NULL,
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username VARCHAR(255),
    FOREIGN KEY (position_id)
        REFERENCES position (position_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (division_id)
        REFERENCES division (division_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (username)
        REFERENCES `user` (username)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE customer_type (
    customer_type_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_type_name VARCHAR(45) NOT NULL
);
CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_type_id INT,
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE NOT NULL,
    customer_gender BIT(1) NOT NULL,
    customer_id_card VARCHAR(45) NOT NULL,
    customer_phone VARCHAR(45) NOT NULL,
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE rent_type (
    rent_type_id INT AUTO_INCREMENT PRIMARY KEY,
    rent_type_name VARCHAR(45) NOT NULL,
    rent_type_cost DOUBLE NOT NULL
);
CREATE TABLE service_type (
    service_type_id INT AUTO_INCREMENT PRIMARY KEY,
    service_type_name VARCHAR(45) NOT NULL
);
CREATE TABLE service (
    service_id VARCHAR(45) PRIMARY KEY,
    service_name VARCHAR(45) NOT NULL,
    service_area INT NOT NULL,
    service_cost DOUBLE NOT NULL,
    service_max_people INT NOT NULL,
    rent_type_id INT NOT NULL,
    service_type_id INT NOT NULL,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE attach_service (
    attach_service_id INT AUTO_INCREMENT PRIMARY KEY,
    attach_service_name VARCHAR(45) NOT NULL,
    attach_service_cost DOUBLE NOT NULL,
    attach_service_unit INT NOT NULL,
    attach_service_status VARCHAR(45) NOT NULL
);
CREATE TABLE contract (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_start_date DATETIME NOT NULL,
    contract_end_date DATETIME,
    contract_deposit INT,
    contract_total_money INT,
    employee_id VARCHAR(45),
    customer_id INT,
    service_id VARCHAR(45),
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (service_id)
        REFERENCES service (service_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE contract_detail (
    contract_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    contract_id INT NOT NULL,
    attach_service_id INT,
    quantity INT,
    FOREIGN KEY (contract_id)
        REFERENCES contract (contract_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (attach_service_id)
        REFERENCES attach_service (attach_service_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);