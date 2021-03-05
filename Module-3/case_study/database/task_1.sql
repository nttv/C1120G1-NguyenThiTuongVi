insert into ViTri(TenViTri)
values
("Le tan"),
("Phuc vu"),
("Chuyen vien"),
("Giam sat"),
("Quan ly"),
("Giam doc");

insert into TrinhDo(TrinhDo)
values
("Trung cap"),
("Cao dang"),
("Dai hoc"),
("Sau dai hoc");

insert into BoPhan(TenBoPhan)
values
("Sale-Marketing"),
("Hanh chinh"),
("Phuc vu"),
("Quan ly");

insert into NhanVien(HoTen,IDViTri,IDTrinhDo,IDBoPhan,NgaySinh,SoCMTND,Luong,SDT,Email,DiaChi)
values
("Tran Quoc Hoang",1,1,3,"2004-01-01","111111111",350,"0901234567",null,null),
("Ho Ngoc Dang Khoa",2,2,3,"2002-01-01","222222222",370,"0902345678",null,null),
("Trinh Thi Khanh Ngoc",3,3,1,"1990-01-01","333333333",400,"0903456789",null,null),
("Nguyen Van T",4,2,2,"1989-01-01","444444444",500,"0904567890",null,null),
("Nguyen Thi Kim",5,3,2,"1995-01-01","555555555",700,"0905678901",null,null),
("Tran Van Chanh",6,4,4,"1980-01-01","666666666",1300,"0906789012",null,null);

insert into LoaiKhach(TenLoaiKhach)
values
("Diamond"),
("Platinum"),
("Gold"),
("Silver"),
("Member");

insert into KhachHang(IDLoaiKhach,HoTen,NgaySinh,SoCMTND,SDT,Email,DiaChi)
values
(1,"Nguyen Van A","2004-01-01","111111111","0901234567",null,"Da Nang"),
(2,"Nguyen Van B","2002-01-01","222222222","0902345678",null,"Quang Ngai"),
(1,"Nguyen Van C","1990-01-01","333333333","0903456789",null,"Vinh"),
(5,"Nguyen Van D","1989-01-01","444444444","0904567890",null,"Quang Tri"),
(2,"Nguyen Van F","2003-05-01","555555555","0905678901",null,"Da Nang"),
(4,"Nguyen Van F","1980-01-01","666666666","0906789012",null,"Hue");

insert into KieuThue(TenKieuThue,Gia)
values
("Nam",80),
("Thang",90),
("Ngay",100),
("Gio",110);

insert into LoaiDichVu(TenLoaiDichVu)
values
("Villa"),
("House"),
("Room");

insert into DichVu(TenDichVu,DienTich,SoTang,SoNguoiToiDa,ChiPhiThue,IDKieuThue,IDLoaiDichVu,TrangThai)
values
("Villa 1",100,3,10,500,3,1,"Available"),
("House 1",60,2,6,300,2,2,"Available"),
("Room 1",40,2,3,250,1,3,"Not available"),
("Villa 2",80,2,8,400,2,1,"Available"),
("Room 2",30,1,2,200,4,3,"Not available");

insert into HopDong(IDNhanVien,IDKhachHang,IDDichVu,NgayLamHopDong,NgayKetThuc,TienDatCoc,TongTien)
values
(1,2,2,"2015-12-12","2019-03-12",100,400),
(1,2,2,"2018-12-12","2019-03-12",100,400),
(1,3,5,"2018-01-12","2019-08-12",100,300),
(1,1,5,"2018-01-12","2019-08-12",100,250),
(1,1,5,"2018-01-12","2019-08-12",100,700),
(2,5,4,"2019-01-12","2020-10-12",100,550),
(5,1,5,"2021-01-12",null,100,190),
(4,3,3,"2019-05-01","2021-05-01",100,560),
(4,6,3,"2018-05-01","2021-05-01",100,450),
(3,4,3,"2019-10-01","2021-05-01",100,300),
(3,4,3,"2019-10-20","2021-05-01",100,670);

insert into DichVuDiKem(TenDichVuDiKem,Gia,DonVi,TrangThaiKhaDung)
values
("Massage",10,1,"Not available"),
("Karaoke",15,1,"Available"),
("Thuc an",20,1,"Not available"),
("Nuoc uong",15,1,"Not available"),
("Thue xe",50,1,"Available");

insert into HopDongChiTiet(IDHopDong,IDDichVuDiKem,SoLuong)
values
(6,1,3),
(6,4,2),
(2,3,3),
(2,4,5),
(6,2,4),
(8,1,4);
