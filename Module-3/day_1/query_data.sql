select * from customers;

select customerName, phone, city, country from customers;

select * from customers
where customerName = "Atelier graphique";

select * from customers
where customerName like "%at%";

select * from customers
where city in ("Nantes", "Las Vegas", "Warszawa", "NYC");

select * from orders;

select * from orders
where orderNumber between 10100 and 10110;

SET SQL_SAFE_UPDATES = 0;
update orders
set status = "Cancelled"
where orderDate <= "2003-03-03" and comments is not null;

select * from orders
where orderDate <= "2003-03-03";

select * from orders
where orderDate <= "2003-03-03" and status like "Shipped";