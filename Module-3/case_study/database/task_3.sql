SELECT 
    *
FROM
    KhachHang
WHERE
    (YEAR(NOW()) - YEAR(birthday)) BETWEEN 18 AND 50
        AND DiaChi IN ('Da Nang' , 'Quang Tri');