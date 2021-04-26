
insert into `position`(position_name)
	values ("Receptionist"),("Serve"),("Expert"),("Supervision"),("Manager"),("Director");

insert into education_degree(education_degree_name)
	values ("Intermediate"),("College"),("University"),("Postgraduate");

insert into division(division_name)
	values ("Sale–Marketing"),("Administration"),("Serve"),("Manager");

insert into `role`(role_name)
	values	("Admin"),("Manager"),("Director"),("Employee");

insert into `user`(username, encrypted_password, enabled)
	values	("hoang", "hoang", 1), ("thuan","thuan", 1), ("khoa","khoa", 1), ("quang","quang", 1), 
			("dong","dong", 1), ("vi","vi", 1),("sang","sang", 1),("phuc","phuc", 1),("long","long", 1), ("nghia","nghia", 1);

insert into user_role(username, role_id)
	values	("nghia",1), ("phuc",2), ("thuan",3), ("khoa",4), ("quang",4), 
			("dong",4), ("vi",2), ("sang",4), ("long",4),("hoang",1);

insert into employee(employee_name,position_id,education_degree_id,division_id,employee_birthday,employee_id_card,
					 employee_salary,employee_phone,employee_email,employee_address,username)
	values 	("Nguyen Trong Thuan",6,4,4,'1997-07-09','207999845112',900.0,'0914112449',"thuan@gmail.com","Da Nang","thuan"),
			("Nguyen Van Khoa",2,1,2,'1999-12-19','205005430',500.0,'(84)+901112911',"khoa@gmail.com","Da Nang","khoa"),
			("Pham Le Quang",1,2,1,'1995-04-24','203999334007',550.0,'0917415940',"quang@gmail.com","Hue","quang"),
			('Nguyen Trung Dong',2,3,1,'1992-05-06','204111334',500.0,'(84)+914221144','dong@gmail.com',"Ha Tinh","dong"),
			("Nguyen Tuong Vi",5,2,4,'1993-09-20','207999494007',930.0,'(84)+912515940',"tuongvi@gmail.com","Da Nang","vi"),
			("Khuong An Sang",2,2,2,'1985-11-04','200314007',520.0,'0918115110',"sang@gmail.com","Quang Tri","sang"),
			("Giang Thi Phuc",4,3,4,'1998-02-25','203310147',700.0,'(84)+907411940',"phuc@gmail.com","Quang Nam","phuc"),
			("Nguyen Van Long",1,1,1,'2000-09-24','203114555',540.0,'(84)+914285363',"long@gmail.com","Hue","long"),
            ("Tran Ngoc Hoang",6,3,4,'1995-10-17','202457884',930.0,'0914552169',"hoang@gmail.com","Quang Nam","hoang"),
			("Cao Trung Nghia",3,4,2,'1994-01-27','201999112456',860.0,'0907402551',"nghia@gmail.com","Quang Ngai","nghia");

insert into customer_type(customer_type_name)
	values ("Diamond"),("Platinum"),("Gold"),("Silver"),("Member");

insert into customer(customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
	values 	("KH-0699",1,"Tran Quoc Hoang",'1995-10-17',1,"205784966","0915682721","hoang@gmail.com","Quang Nam"),
			("KH-0532",4,"Nguyen Hoang Bao Ngoc",'1997-12-05',1,"205999757536","(84)+917949397","ngoc@gmail.com","Quang Tri"),
			("KH-8704",5,"Hoang Le Quang",'1993-11-23',0,"205999942980","0902007075","quang@gmail.com","Hue"),
			("KH-0802",2,"Tran Hoang Sang",'1996-12-21',1,"205155491","(84)+914610130","sang@gmail.com","Vinh"),
			("KH-9696",2,"Cai Truong Cam Van",'1998-04-05',0,"205455263","0919262410","baongoc@gmail.com","Quang Tri"),
            ("KH-7556",3,"Ho Ngoc Dang Khoa",'1999-08-05',1,"205999332103","0902558286","khoa@gmail.com","Hue"),
            ("KH-6008",5,"Nguyen Ngoc Thuan",'1998-11-30',0,"205162301","(84)+908744685","thuan@gmail.com","Quang Tri"),
            ("KH-5599",1,"Nguyen Ngoc Dong",'1985-02-01',1,"205999286084","0909257543","dong@gmail.com","Da Nang"),
            ("KH-4521",1,"Nguyen Thi Tuong Vi",'1992-06-03',0,"205999369714","0917676972","vi.36@gmail.com","Da Nang"),
            ("KH-9088",4,"Ho Nhat Long",'1999-11-08',1,"205734522","0916009807","long@gmail.com","Hue"),
            ("KH-3726",2,"Nguyen Thi Thu Ha",'1993-10-24',0,"205066974","0909004921","ha@codegym.vn","Da Nang"),
            ("KH-2686",3,"Nguyen Van Phuc",'1991-08-07',1,"205999381448","(84)+902965588","phuc@gmail.com","Quang Nam"),
            ("KH-1241",2,"Nguyen Thanh Tung",'1988-02-08',1,"205317845","(84)+907843956","tung@gmail.com","Quang Nam"),
            ("KH-3004",3,"Le Van Quang",'1993-11-28',1,"205083310","0911823963","quang@gmail.com","Quang Nam");

insert into rent_type(rent_type_name,rent_type_cost)
	values ("Rent by Hour",50.0),("Rent by Day",500.0),("Rent by Month",7000.0),("Rent by Year",60000.0);

insert into service_type(service_type_name)
	values ("Villa"),("House"),("Room");

insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,
					standard_room,description_other_convenience,pool_area,number_of_floors)
	values 	("DV-6388","Villa-6388",50,500.0,10,2,1,"VIP","6388-description",45.0,6),
            ("DV-4581","House-4581",38,300.0,8,2,2,"Normal","none",0,7),
            ("DV-1478","Room-1478",26,100.0,7,3,3,"","",0,0),
            ("DV-9701","Villa-9701",65,550.0,15,3,1,"Bussiness","9701-description",55.0,9),
            ("DV-0207","House-0207",30,285.0,7,1,2,"VIP","none",0,5),
            ("DV-3417","Room-3417",25,125.0,11,4,3,"","",0,0);

insert into attach_service(attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
	values 	("Massage",20,"times","available"),
			("Karaoke",15,"hours","not available"),
			("Food",3,"plates","available"),
			("Water",1,"bottles","available"),
			("Car rental",10,"times","available");

insert into contract(employee_id,customer_id,service_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money)
	values 	(2,"KH-4521","DV-6388",'2020-12-01','2021-02-26',1000,2000),
			(5,"KH-6008","DV-1478",'2019-01-25','2019-03-22',500,1000),
			(4,"KH-9088","DV-9701",'2018-08-01','2018-12-20',750,1500),
			(6,"KH-1241","DV-3417",'2021-01-01','2021-03-11',1500,2500),
			(1,"KH-0802","DV-4581",'2020-09-07','2021-04-16',2000,5000),
			(7,"KH-3726","DV-0207",'2016-11-23','2017-02-19',400,1000),
			(8,"KH-5599","DV-9701",'2017-05-23','2017-06-26',600,1200),
			(6,"KH-9696","DV-1478",'2020-06-14','2020-09-02',700,1000),
			(9,"KH-2686","DV-6388",'2018-10-17','2018-10-22',350,1000)
            ;

insert into contract_detail(contract_id,attach_service_id,quantity) /*1-9*/ /*1-5*/
	values 	(2,4,1),(3,1,2),(1,2,1),(4,3,3),(6,5,2),(7,4,3),(8,1,2),
			(9,2,4),(1,3,2),(5,5,4),(4,4,5),(3,2,5),(2,2,1),(2,1,3),
            (3,3,2),(6,2,6),(8,2,4),(9,5,4),(4,2,4),(6,1,2),(7,1,4),
            (6,4,1),(3,4,4),(1,4,3);
