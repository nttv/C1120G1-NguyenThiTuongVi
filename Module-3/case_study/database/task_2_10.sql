/* TASK 2 */
SELECT 
    *
FROM
    NhanVien
WHERE
    (HoTen LIKE 'H%' OR HoTen LIKE 'T%'
        OR HoTen LIKE 'K%')
        AND LENGTH(HoTen) <= 15;
        
/* TASK 3 */
SELECT 
    *
FROM
    KhachHang
WHERE
    (YEAR(NOW()) - YEAR(NgaySinh)) BETWEEN 18 AND 50
        AND DiaChi IN ('Da Nang' , 'Quang Tri');

/* TASK 4 */
SELECT 
    KhachHang.IDKhachHang,
    HoTen,
    LoaiKhach.TenLoaiKhach,
    COUNT(*) AS SoLanDatPhong
FROM
    KhachHang
        INNER JOIN
    LoaiKhach ON KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
        INNER JOIN
    HopDong ON KhachHang.IDKhachHang = HopDong.IDKhachHang
WHERE
    LoaiKhach.TenLoaiKhach = 'Diamond'
GROUP BY IDKhachHang
ORDER BY SoLanDatPhong;

/* TASK 5 */
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
            HopDong.IDHopDong IN (SELECT DISTINCT
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

/* TASK 6 */
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

/* TASK 7 */
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

/* TASK 8 */


/* TASK 9 */


/* TASK 10 */

