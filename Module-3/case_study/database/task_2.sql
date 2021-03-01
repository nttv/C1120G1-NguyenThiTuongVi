SELECT 
    *
FROM
    NhanVien
WHERE
    HoTen LIKE ('H%' OR 'T%' OR 'K%')
        AND LEN(HoTen) <= 15;