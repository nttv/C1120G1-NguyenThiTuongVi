create database ss4_exercise;
use ss4_exercise;

CREATE TABLE Student (
    ID INT NOT NULL,
    TEN VARCHAR(50) NOT NULL,
    TUOI INT NOT NULL,
    KHOAHOC VARCHAR(10) NOT NULL,
    SOTIEN INT NOT NULL
);

insert into Student(ID, TEN, TUOI, KHOAHOC, SOTIEN)
values
(1, "Hoang", 21, "CNTT", 400000),
(2, "Viet", 19, "DTVT", 320000),
(3, "Thanh", 18, "KTDN", 400000),
(4, "Nhan", 19, "CK", 450000),
(5, "Huong", 20, "TCNH", 500000),
(5, "Huong", 20, "TCNH", 200000);

select * from Student;

-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
SELECT ID, TEN, TUOI, KHOAHOC, SOTIEN
FROM Student
WHERE ten = 'Huong';

-- Viết câu lệnh lấy ra tổng số tiền của Huong
SELECT ID, TEN, TUOI, KHOAHOC, SUM(SOTIEN) AS TONGTIEN
FROM Student
WHERE ten = 'Huong';

-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
SELECT DISTINCT ID, TEN, TUOI, KHOAHOC
FROM Student;
