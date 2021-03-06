-- TASK 21
-- Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên
-- có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ
-- với ngày lập hợp đồng là “12/12/2019”

-- TASK 22
-- Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu”
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này

-- TASK 23
-- Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó
-- với Id Khách hàng được truyền vào như là 1 tham số của Sp_1

-- TASK 24
-- Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được
-- trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan

-- TASK 25
-- Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng
-- số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database

-- TASK 26
-- Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem
-- thời gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng
-- phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép
-- cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải
-- lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database

-- TASK 27
-- Tạo user function thực hiện yêu cầu sau:
-- a. Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ
-- b. Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng
-- đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian
-- dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng).
-- Mã của Khách hàng được truyền vào như là 1 tham số của function này

-- TASK 28
-- Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ
-- là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó
-- (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan
-- (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác
