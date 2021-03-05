delimiter $$
create procedure getCustomerById(IN id int(11))
begin
	select * from customers where customerNumber = id;
end $$
delimiter ;

call getCustomerById(175);
call getCustomerById(203);

delimiter $$
create procedure getCustomerCountByCity(IN inCity varchar(50), OUT total int)
begin
	select count(customerNumber)
    into total
    from customers
    where city = inCity;
end $$
delimiter ;

call getCustomerCountByCity('Nantes', @total);
SELECT @total AS tongKhach;

delimiter $$
create procedure setCounter(INOUT counter int, IN inc int)
begin
	set counter = counter + inc;
end $$
delimiter ;

SET @counter = 1;
call setCounter(@counter, 6);
call setCounter(@counter, 2);
call setCounter(@counter, 4);
SELECT @counter AS so_luong;