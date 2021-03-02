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
("Hoang Le Quang",1,1,3,"2004-01-01","111111111",350,"0901234567",null,null),
("Hoang Nu Khanh Quynh",2,2,3,"2002-01-01","222222222",370,"0902345678",null,null),
("Trinh Thi Khanh Ngoc",3,3,1,"1990-01-01","333333333",400,"0903456789",null,null),
("Nguyen Van A",4,2,2,"1989-01-01","444444444",500,"0904567890",null,null),
("Kim Ly",5,3,2,"1995-01-01","555555555",700,"0905678901",null,null),
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
(1,"NVA","2004-01-01","111111111","0901234567",null,"Da Nang"),
(2,"NVB","2002-01-01","222222222","0902345678",null,"Quang Tri"),
(1,"NVC","1990-01-01","333333333","0903456789",null,"Hue"),
(5,"NVD","1989-01-01","444444444","0904567890",null,"Quang Nam"),
(3,"NVE","1995-01-01","555555555","0905678901",null,"Da Nang"),
(4,"NVF","1980-01-01","666666666","0906789012",null,"Da Nang");

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
(1,2,2,"2018-12-12","2019-03-12",100,0),
(1,1,5,"2018-01-12","2019-08-12",100,0),
(2,5,4,"2020-01-12","2020-10-12",100,0),
(5,1,5,"2021-01-12",null,100,0),
(4,3,3,"2019-05-01","2021-05-01",100,0),
(4,3,3,"2018-05-01","2021-05-01",100,0);

insert into DichVuDiKem(TenDichVuDiKem,Gia,DonVi,TrangThaiKhaDung)
values
("Massage",10,1,"not available"),
("Karaoke",15,1,"available"),
("Thuc an",20,1,"not available"),
("Nuoc uong",15,1,"not available"),
("Thue xe",50,1,"available");

insert into HopDongChiTiet(IDHopDong,IDDichVuDiKem,SoLuong)
values
(1,1,3),
(2,3,3),
(2,4,5);
