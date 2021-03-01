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
("Hoang Le Quang",1,1,3,"2004-01-01","111111111",7000000,"0901234567",null,null),
("Hoang Nu Khanh Quynh",2,2,3,"2002-01-01","222222222",8000000,"0902345678",null,null),
("Trinh Thi Khanh Ngoc",3,3,1,"1990-01-01","333333333",9000000,"0903456789",null,null),
("Nguyen Van A",4,2,2,"1989-01-01","444444444",10000000,"0904567890",null,null),
("Kim Ly",5,3,2,"1995-01-01","555555555",15000000,"0905678901",null,null),
("Tran Van Chanh",6,4,4,"1980-01-01","666666666",30000000,"0906789012",null,null);

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

insert into DichVu()
values
(),
();

insert into HopDong()
values
(),
();

insert into DichVuDiKem(TenDichVuDiKem,Gia,DonVi,TrangThaiKhaDung)
values
("Massage"),
("Karaoke"),
("Thuc an"),
("Nuoc uong"),
("Thue xe");

insert into HopDongChiTiet()
values
(),
();
