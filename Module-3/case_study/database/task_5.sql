SELECT 
    IDKhachHang,
    HoTen,
    TenLoaiKhach,
    IDHopDong,
    TenDichVu,
    NgayLamHopDong,
    NgayKetThuc,
    TongTien
FROM
    KhachHang
        INNER JOIN
    LoaiKhach ON KhachHang.IDLoaiKhach = LoaiKhach.IDLoaiKhach
        INNER JOIN
    HopDong ON KhachHang.IDKhachHang = HopDong.IDKhachHang
        INNER JOIN
    HopDongChiTiet ON HopDong.IDHopDongChiTiet = HopDongChiTiet.IDHopDongChiTiet