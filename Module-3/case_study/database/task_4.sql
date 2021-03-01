SELECT 
    IDKhachHang,
    HoTen,
    LoaiKhach.TenLoaiKhach,
    COUNT(*) AS SoLanDatPhong
FROM
    KhachHang
        INNER JOIN
    LoaiKhach ON IDLoaiKhach = LoaiKhach.IDLoaiKhach
        INNER JOIN
    HopDong ON IDKhachHang = HopDong.IDKhachHang
WHERE
    LoaiKhach.IDLoaiKhach = 'Diamond'
GROUP BY IDKhachHang
ORDER BY SoLanDatPhong;