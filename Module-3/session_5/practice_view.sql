CREATE VIEW customer_views AS
    SELECT 
        customerName, customerNumber, phone
    FROM
        customers;
    
SELECT *
FROM customer_views;

CREATE OR REPLACE VIEW customer_views AS
    SELECT 
        customerNumber,
        customerName,
        contactFirstName,
        contactLastName,
        phone
    FROM customers
    WHERE city = 'Nantes';
    
SELECT *
FROM customer_views;

drop view customer_views;