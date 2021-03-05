-- TASK 2
-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống
-- có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự
SELECT *
FROM NhanVien
WHERE
    -- (HoTen LIKE 'H%' OR HoTen LIKE 'T%' OR HoTen LIKE 'K%')
    (HoTen regexp ' [HTK][a-z]*$')
        AND LENGTH(HoTen) <= 15;

-- TASK 3
-- Hiển thị thông tin của tất cả khách hàng
-- có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”
SELECT *
FROM KhachHang
WHERE
    TIMESTAMPDIFF(YEAR, NgaySinh, CURDATE()) BETWEEN 18 AND 50
        AND DiaChi IN ('Da Nang' , 'Quang Tri');

-- TASK 4
-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”
SELECT 
    KhachHang.IDKhachHang,
    KhachHang.HoTen,
    LoaiKhach.TenLoaiKhach,
    COUNT(*) AS SoLanDatPhong
FROM
    KhachHang
        INNER JOIN
    LoaiKhach ON KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
        LEFT JOIN
    HopDong ON KhachHang.IDKhachHang = HopDong.IDKhachHang
WHERE
    LoaiKhach.TenLoaiKhach = 'Diamond'
GROUP BY IDKhachHang
ORDER BY SoLanDatPhong;

-- TASK 5
-- Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra)
SELECT
    KhachHang.IDKhachHang,
    KhachHang.HoTen,
    LoaiKhach.TenLoaiKhach,
    HopDong.IDHopDong,
    DichVu.TenDichVu,
    HopDong.NgayLamHopDong,
    HopDong.NgayKetThuc,
    CASE
        WHEN
            HopDong.IDHopDong IN (
					SELECT
                    IDHopDong
                FROM
                    HopDongChiTiet)
        THEN
            DichVu.ChiPhiThue + SUM((HopDongChiTiet.SoLuong * DichVuDiKem.Gia))
        ELSE DichVu.ChiPhiThue
    END AS TongTien
FROM
    KhachHang
        LEFT JOIN
    LoaiKhach ON KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
        LEFT JOIN
    HopDong ON KhachHang.IDKhachHang = HopDong.IDKhachHang
        LEFT JOIN
    DichVu ON HopDong.IDDichVu = DichVu.IDDichVu
        LEFT JOIN
    HopDongChiTiet ON HopDong.IDHopDong = HopDongChiTiet.IDHopDong
        LEFT JOIN
    DichVuDiKem ON HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
GROUP BY HopDong.IDHopDong;

-- TASK 6
-- Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ
-- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3)
SELECT 
    DichVu.IDDichVu,
    TenDichVu,
    DienTich,
    ChiPhiThue,
    LoaiDichVu.TenLoaiDichVu,
    HopDong.NgayLamHopDong
FROM
    DichVu
        INNER JOIN
    LoaiDichVu ON DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
        LEFT JOIN
    HopDong ON DichVu.IDDichVu = HopDong.IDDichVu
WHERE
    DichVu.IDDichVu NOT IN (SELECT 
            IDDichVu
        FROM
            HopDong
        WHERE
            YEAR(NgayLamHopDong) >= 2019);

-- TASK 7
-- Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018
-- nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019
SELECT 
    DichVu.IDDichVu,
    TenDichVu,
    DienTich,
    SoNguoiToiDa,
    ChiPhiThue,
    LoaiDichVu.TenLoaiDichVu
FROM
    DichVu
        INNER JOIN
    LoaiDichVu ON DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
		INNER JOIN
    HopDong ON DichVu.IDDichVu = HopDong.IDDichVu
WHERE
    DichVu.IDDichVu IN (SELECT DISTINCT
            IDDichVu
        FROM
            HopDong
        WHERE
            YEAR(NgayLamHopDong) = 2018)
        AND DichVu.IDDichVu NOT IN (SELECT DISTINCT
            IDDichVu
        FROM
            HopDong
        WHERE
            YEAR(NgayLamHopDong) = 2019);

-- TASK 8
-- Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
SELECT DISTINCT HoTen
FROM KhachHang;

SELECT HoTen
FROM KhachHang
GROUP BY HoTen;

SELECT HoTen
FROM KhachHang 
UNION
SELECT HoTen
FROM KhachHang;

-- TASK 9
-- Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng
-- trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng
SELECT 
    Thang, COUNT(IDKhachHang) AS SoLuongKhachHang
FROM
    (SELECT DISTINCT
        MONTH(NgayLamHopDong) AS Thang, IDKhachHang
    FROM
        HopDong
    WHERE
        YEAR(NgayLamHopDong) = 2019) AS DistinctCustomers
GROUP BY Thang
ORDER BY Thang;

-- TASK 10
-- Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc,
-- SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet)
SELECT 
    HopDong.IDHopDong,
    NgayLamHopDong,
    NgayKetthuc,
    TienDatCoc,
    COUNT(IDHopDongChiTiet) AS SoLuongDichVuDiKem
FROM
    HopDong
        LEFT JOIN
    HopDongChiTiet ON HopDong.IDHopDong = HopDongChiTiet.IDHopDong
GROUP BY HopDong.IDHopDong;