use ss12_user_jdbc;

DELIMITER $$
create procedure find_by_id(in user_id int)
begin
	select * from users
    where users.id = user_id;
end $$
DELIMITER ;

DELIMITER $$
create procedure insert_user(in user_name varchar(50), in user_email varchar(50), in user_country varchar(50))
begin
	insert into users (`name`, email, country)
    values (user_name, user_email, user_country);
end $$
DELIMITER ;

call find_by_id(3);
call insert_user("Anna","anna@gmail.com","France");

CREATE TABLE permission (
    id INT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE user_permission (
    permission_id INT,
    user_id INT,
    PRIMARY KEY (permission_id , user_id),
    FOREIGN KEY (permission_id)
        REFERENCES permission (id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

insert into permission(`name`)
values
('add'),
('edit'),
('delete'),
('view');

DELIMITER $$
create procedure find_all_users()
begin
	select * from users;
end $$
DELIMITER ;

DELIMITER $$
create procedure update_user(in user_id int, in user_name varchar(50), in user_email varchar(50), in user_country varchar(50))
begin
	update users
    set `name` = user_name, email = user_email, country = user_country
    where id = user_id;
end $$
DELIMITER ;

DELIMITER $$
create procedure delete_user(in user_id int)
begin
	delete from users where id = user_id;
end $$
DELIMITER ;

