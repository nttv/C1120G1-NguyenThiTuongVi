-- TASK 11
-- Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng
-- có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”
SELECT 
    KhachHang.HoTen,
    KhachHang.DiaChi,
    HopDong.IDHopDong,
    TenDichVuDiKem
FROM
    KhachHang
        INNER JOIN
    LoaiKhach ON KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
        INNER JOIN
    HopDong ON KhachHang.IDKhachHang = HopDong.IDKhachHang
        INNER JOIN
    HopDongChiTiet ON HopDong.IDHopDong = HopDongChiTiet.IDHopDong
        INNER JOIN
    DichVuDiKem ON HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
WHERE
    LoaiKhach.TenLoaiKhach = 'Diamond'
        AND (KhachHang.DiaChi IN ('Vinh' , 'Quang Ngai'))
ORDER BY KhachHang.HoTen;

-- TASK 12
-- Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang,
-- TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019
SELECT 
    HopDong.IDHopDong,
    NhanVien.HoTen AS TenNhanVien,
    KhachHang.HoTen AS TenKhachHang,
    KhachHang.SDT AS SoDienThoaiKhachHang,
    DichVu.TenDichVu,
    COUNT(HopDongChiTiet.IDHopDongChiTiet) AS SoLuongDichVuDikem,
    HopDong.TienDatCoc,
    HopDong.NgayLamHopDong
FROM
    HopDong
        INNER JOIN
    NhanVien ON HopDong.IDNhanVien = NhanVien.IDNhanVien
        INNER JOIN
    KhachHang ON HopDong.IDKhachHang = KhachHang.IDKhachHang
        INNER JOIN
    DichVu ON HopDong.IDDichVu = DichVu.IDDichVu
        LEFT JOIN
    HopDongChiTiet ON HopDong.IDHopDong = HopDongChiTiet.IDHopDong
WHERE
    YEAR(HopDong.NgayLamHopDong) = 2019
        AND MONTH(HopDong.NgayLamHopDong) IN (10 , 11, 12)
        AND MONTH(HopDong.NgayLamHopDong) NOT IN (1 , 2, 3, 4, 5, 6)
GROUP BY HopDong.IDHopDong
ORDER BY HopDong.IDHopDong;

-- TASK 13
-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau)
SELECT 
    DichVuDiKem.IDDichVuDiKem,
    DichVuDiKem.TenDichVuDiKem,
    COUNT(HopDongChiTiet.IDDichVuDiKem) AS SoLanSuDung
FROM
    HopDongChiTiet
        INNER JOIN
    DichVuDiKem ON HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
GROUP BY HopDongChiTiet.IDDichVuDiKem
HAVING COUNT(HopDongChiTiet.IDDichVuDiKem) = (SELECT 
        MAX(SoLanSuDung)
    FROM
        (SELECT 
            COUNT(IDDichVuDiKem) AS SoLanSuDung
        FROM
            HopDongChiTiet
        GROUP BY IDDichVuDiKem) AS SoLanSuDungDichVuDiKem);

-- TASK 14
-- Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
SELECT 
    HopDong.IDHopDong,
    LoaiDichVu.TenLoaiDichVu,
    DichVuDiKem.TenDichVuDiKem,
    COUNT(HopDongChiTiet.IDDichVuDiKem) AS SoLanSuDung
FROM
    HopDong
        INNER JOIN
    DichVu ON HopDong.IDDichVu = DichVu.IDDichVu
        INNER JOIN
    LoaiDichVu ON DichVu.IDLoaiDichVu = LoaiDichVu.IDLoaiDichVu
        INNER JOIN
    HopDongChiTiet ON HopDong.IDHopDong = HopDongChiTiet.IDHopDong
        INNER JOIN
    DichVuDiKem ON HopDongChiTiet.IDDichVuDiKem = DichVuDiKem.IDDichVuDiKem
GROUP BY HopDongChiTiet.IDDichVuDiKem
HAVING COUNT(HopDongChiTiet.IDDichVuDiKem) = 1
ORDER BY HopDong.IDHopDong;

-- TASK 15
-- Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan,
-- SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019
SELECT 
    NhanVien.IDNhanVien,
    HoTen,
    TrinhDo.TrinhDo,
    BoPhan.TenBoPhan,
    SDT AS SoDienThoai,
    DiaChi,
    COUNT(IDHopDong) AS SoHopDong
FROM
    NhanVien
        INNER JOIN
    TrinhDo ON NhanVien.IDTrinhDo = TrinhDo.IDTrinhDo
        INNER JOIN
    BoPhan ON NhanVien.IDBoPhan = BoPhan.IDBoPhan
        LEFT JOIN
    HopDong ON NhanVien.IDNhanVien = HopDong.IDNhanVien
WHERE
    YEAR(NgayLamHopDong) BETWEEN 2018 AND 2019
GROUP BY NhanVien.IDNhanVien
HAVING COUNT(IDHopDong) <= 3;

-- TASK 16
-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019
SELECT * FROM NhanVien;
DELETE FROM NhanVien
WHERE
    IDNhanVien NOT IN (SELECT 
        IDNhanVien
    FROM
        HopDong
    WHERE
        YEAR(NgayLamHopDong) BETWEEN 2017 AND 2019);

-- TASK 17
-- Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ Platinium lên Diamond, chỉ cập nhật
-- những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ/500$
SELECT * FROM KhachHang;

UPDATE KhachHang 
SET 
    IDLoaiKhach = (SELECT IDLoaiKhach FROM LoaiKhach WHERE TenLoaiKhach = 'Diamond')
WHERE
    IDLoaiKhach = (SELECT IDLoaiKhach FROM LoaiKhach WHERE TenLoaiKhach = 'Platinum')
        AND IDKhachHang IN (SELECT 
            IDKhachHang
        FROM
            HopDong
        GROUP BY IDKhachHang
        HAVING SUM(TongTien) > 500);

-- TASK 18
-- Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng)
SELECT * FROM KhachHang;

DELETE FROM KhachHang 
WHERE
    IDKhachHang IN (SELECT 
        IDKhachHang
    FROM
        HopDong
    WHERE
        YEAR(NgayLamHopDong) < 2016);

-- TASK 19
-- Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi
UPDATE DichVuDiKem 
SET 
    Gia = Gia * 2
WHERE
    IDDichVuDiKem IN (SELECT 
            IDDichVuDiKem
        FROM
            HopDongChiTiet
                INNER JOIN
            HopDong ON HopDongChiTiet.IDHopDong = HopDong.IDHopDong
        WHERE
            YEAR(NgayLamHopDong) = 2019
        GROUP BY HopDongChiTiet.IDDichVuDiKem
        HAVING COUNT(IDDichVuDiKem) > 1);

SELECT 
    DichVuDiKem.*,
    COUNT(HopDongChiTiet.IDDichVuDiKem) AS SoLanSuDung
FROM
    DichVuDiKem
        LEFT JOIN
    HopDongChiTiet ON DichVuDiKem.IDDichVuDiKem = HopDongChiTiet.IDDichVuDiKem
GROUP BY DichVuDiKem.IDDichVuDiKem;

-- TASK 20
-- Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
SELECT 
    IDNhanVien AS ID,
    HoTen,
    Email,
    SDT AS SoDienThoai,
    NgaySinh,
    DiaChi
FROM
    NhanVien 
UNION ALL SELECT 
    IDKhachHang AS ID,
    HoTen,
    Email,
    SDT AS SoDienThoai,
    NgaySinh,
    DiaChi
FROM
    KhachHang;
