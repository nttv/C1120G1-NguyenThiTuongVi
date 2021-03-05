delimiter $$
create procedure findAllCustomer()
begin
	select * from customers;
end $$
delimiter ;

call findAllCustomer();

delimiter $$
drop procedure if exists findAllCustomer $$
create procedure findAllCustomer()
begin
	select * from customers where customerNumber = 175;
end $$
delimiter ;

call findAllCustomer();