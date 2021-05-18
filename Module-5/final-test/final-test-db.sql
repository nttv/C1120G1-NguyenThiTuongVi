insert into student_group(groupName)
values
("Group 1"),
("Group 2"),
("Group 3");

insert into supervisor(supervisorName)
values
("Doan Phuoc Trung"),
("Nguyen Vu Thanh Tien"),
("Dang Chi Trung"),
("Tran Van Chanh"),
("Truong Tan Hai"),
("Doan Ngoc Linh");

insert into student(studentId, email, phone, studentName, topic, groupId, supervisorId)
values
(102110130, "chien.pham@gmail.com", "0909123456", "Pham Van Chien", "Topic 1", 1, 3),
(102110131, "hoang.tran@gmail.com", "090588889999", "Tran Quoc Hoang", "Topic 2", 2, 6),
(102110132, "quang.hoang@gmail.com", "09015678901", "Hoang Le Quang", "Topic 3", 3, 1),
(102110133, "thuan.nguyen@gmail.com", "0903030303", "Nguyen Ngoc Thuan", "Topic 4", 2, 5),
(102110134, "sang.tran@gmail.com", "0977456123", "Tran Hoang Sang", "Topic 5", 1, 4);
