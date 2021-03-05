-- drop database ss2_car_selling_db;
create database ss2_car_selling_db;
use ss2_car_selling_db;

CREATE TABLE customers (
    customerNumber INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(50) NOT NULL,
    contactLastName VARCHAR(50) NOT NULL,
    contactFirstName VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL,
    country VARCHAR(50) NOT NULL,
    creditLimit DOUBLE
);

CREATE TABLE offices (
    officeCode VARCHAR(10) PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    addressLine1 VARCHAR(50) NOT NULL,
    addressLine2 VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50) NOT NULL,
    postalCode VARCHAR(15) NOT NULL
);

CREATE TABLE employees (
    employeeNumber INT AUTO_INCREMENT PRIMARY KEY,
    lastName VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    jobTitle VARCHAR(50) NOT NULL
);

CREATE TABLE products (
    productCode VARCHAR(15) PRIMARY KEY,
    productName VARCHAR(70) NOT NULL,
    productScale VARCHAR(10) NOT NULL,
    productVendor VARCHAR(50) NOT NULL,
    productDescription TEXT NOT NULL,
    quantityInStock INT NOT NULL,
    buyPrice DOUBLE NOT NULL,
    MSRP DOUBLE NOT NULL
);

CREATE TABLE productlines (
    productLine VARCHAR(50) PRIMARY KEY,
    textDescription TEXT,
    image VARCHAR(255)
);

CREATE TABLE orders (
    orderNumber INT AUTO_INCREMENT PRIMARY KEY,
    orderDate DATE NOT NULL,
    requiredDate DATE NOT NULL,
    shippedDate DATE,
    status VARCHAR(15) NOT NULL,
    comments TEXT,
    quantityOrdered INT NOT NULL,
    priceEach DOUBLE NOT NULL
);

CREATE TABLE payments (
    customerNumber INT NOT NULL,
    checkNumber VARCHAR(50) PRIMARY KEY,
    paymentDate DATE NOT NULL,
    amount DOUBLE NOT NULL
);

alter table customers
add employeeNumber INT NOT NULL,
add FOREIGN KEY (employeeNumber) REFERENCES employees (employeeNumber);
        
alter table employees
add officeCode VARCHAR(10) NOT NULL,
add managerNumber int NOT NULL,
add FOREIGN KEY (officeCode) REFERENCES offices (officeCode),
add FOREIGN KEY (managerNumber) REFERENCES employees (employeeNumber);

alter table products
add productLine VARCHAR(50) NOT NULL,
add FOREIGN KEY (productLine) REFERENCES productlines (productLine);

alter table orders
add customerNumber INT NOT NULL,
add FOREIGN KEY (customerNumber) REFERENCES customers (customerNumber);

alter table payments
add FOREIGN KEY (customerNumber) REFERENCES customers (customerNumber);

CREATE TABLE orderDetails (
    orderNumber INT,
    productCode VARCHAR(15),
    quantityOrdered INT NOT NULL,
    priceEach DOUBLE NOT NULL,
    PRIMARY KEY (orderNumber , productCode),
    FOREIGN KEY (orderNumber)
        REFERENCES orders (orderNumber),
    FOREIGN KEY (productCode)
        REFERENCES products (productCode)
);

alter table orders
drop quantityOrdered,
drop priceEach;