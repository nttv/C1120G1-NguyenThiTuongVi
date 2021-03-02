drop database cs_database;
create database cs_database;
use cs_database;

CREATE TABLE ViTri (
    IDViTri INT AUTO_INCREMENT PRIMARY KEY,
    TenViTri VARCHAR(45) NOT NULL
);
CREATE TABLE TrinhDo (
    IDTrinhDo INT AUTO_INCREMENT PRIMARY KEY,
    TrinhDo VARCHAR(45) NOT NULL
);
CREATE TABLE BoPhan (
    IDBoPhan INT AUTO_INCREMENT PRIMARY KEY,
    TenBoPhan VARCHAR(45) NOT NULL
);
CREATE TABLE NhanVien (
    IDNhanVien INT AUTO_INCREMENT PRIMARY KEY,
    HoTen VARCHAR(100) NOT NULL,
    IDViTri INT NOT NULL,
    IDTrinhDo INT NOT NULL,
    IDBoPhan INT NOT NULL,
    NgaySinh DATE NOT NULL,
    SoCMTND VARCHAR(45) NOT NULL UNIQUE,
    Luong int NOT NULL,
    SDT VARCHAR(45) NOT NULL,
    Email VARCHAR(45),
    DiaChi VARCHAR(45),
    FOREIGN KEY (IDViTri)
        REFERENCES ViTri (IDViTri),
    FOREIGN KEY (IDTrinhDo)
        REFERENCES TrinhDo (IDTrinhDo),
    FOREIGN KEY (IDBoPhan)
        REFERENCES BoPhan (IDBoPhan)
);
CREATE TABLE LoaiKhach (
    IDLoaiKhach INT AUTO_INCREMENT PRIMARY KEY,
    TenLoaiKhach VARCHAR(45) NOT NULL
);
CREATE TABLE KhachHang (
    IDKhachHang INT AUTO_INCREMENT PRIMARY KEY,
    IDLoaiKhach INT NOT NULL,
    HoTen VARCHAR(45) NOT NULL,
    NgaySinh DATE NOT NULL,
    SoCMTND VARCHAR(45) NOT NULL,
    SDT VARCHAR(45) NOT NULL,
    Email VARCHAR(45),
    DiaChi VARCHAR(45),
    FOREIGN KEY (IDLoaiKhach)
        REFERENCES LoaiKhach (IDLoaiKhach)
);
CREATE TABLE KieuThue (
    IDKieuThue INT AUTO_INCREMENT PRIMARY KEY,
    TenKieuThue VARCHAR(45) NOT NULL,
    Gia INT NOT NULL
);
CREATE TABLE LoaiDichVu (
    IDLoaiDichVu INT AUTO_INCREMENT PRIMARY KEY,
    TenLoaiDichVu VARCHAR(45) NOT NULL
);
CREATE TABLE DichVu (
    IDDichVu INT AUTO_INCREMENT PRIMARY KEY,
    TenDichVu VARCHAR(45) NOT NULL,
    DienTich INT NOT NULL,
    SoTang INT NOT NULL,
    SoNguoiToiDa VARCHAR(45) NOT NULL,
    ChiPhiThue VARCHAR(45) NOT NULL,
    IDKieuThue INT,
    IDLoaiDichVu INT,
    TrangThai VARCHAR(45),
    FOREIGN KEY (IDKieuThue)
        REFERENCES KieuThue (IDKieuThue),
    FOREIGN KEY (IDLoaiDichVu)
        REFERENCES LoaiDichVu (IDLoaiDichVu)
);
CREATE TABLE HopDong (
    IDHopDong INT AUTO_INCREMENT PRIMARY KEY,
    IDNhanVien INT NOT NULL,
    IDKhachHang INT NOT NULL,
    IDDichVu INT NOT NULL,
    NgayLamHopDong DATE NOT NULL,
    NgayKetThuc DATE,
    TienDatCoc INT NOT NULL,
    TongTien INT NOT NULL,
    FOREIGN KEY (IDNhanVien)
        REFERENCES NhanVien (IDNhanVien),
    FOREIGN KEY (IDKhachHang)
        REFERENCES KhachHang (IDKhachHang),
    FOREIGN KEY (IDDichVu)
        REFERENCES DichVu (IDDichVu)
);
CREATE TABLE DichVuDiKem (
    IDDichVuDiKem INT AUTO_INCREMENT PRIMARY KEY,
    TenDichVuDiKem VARCHAR(45) NOT NULL,
    Gia INT NOT NULL,
    DonVi INT NOT NULL,
    TrangThaiKhaDung VARCHAR(45) NOT NULL
);
CREATE TABLE HopDongChiTiet (
    IDHopDongChiTiet INT AUTO_INCREMENT PRIMARY KEY,
    IDHopDong INT NOT NULL,
    IDDichVuDiKem INT,
    SoLuong INT,
    FOREIGN KEY (IDHopDong)
        REFERENCES HopDong (IDHopDong),
    FOREIGN KEY (IDDichVuDiKem)
        REFERENCES DichVuDiKem (IDDichVuDiKem)
);

