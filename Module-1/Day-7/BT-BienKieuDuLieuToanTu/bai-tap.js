function bai1() {
    let physics = parseInt(prompt("Nhập điểm môn Vật lý"));
    let chemistry = parseInt(prompt("Nhập điểm môn hóa học"));
    let biology = parseInt(prompt("Nhập điểm môn Sinh học"));
    let sum = physics + chemistry + biology;
    let average = sum / 3;
    alert("Tổng điểm là " + sum);
    alert("Điểm trung bình là " + average);
}

function bai2() {
    let C = parseInt(prompt("Nhập độ C"));
    let F = C * 9 / 5 + 32;
    alert("Độ F = " + F);
}

function bai3() {
    let r = parseInt(prompt("Nhập bán kính hình tròn"));
    let area = r * r * Math.PI;
    let parameter = 2* Math.PI * r;
    alert("Diện tích hình tròn = " + area);
    alert("Chu vi hình tròn = " + parameter);
}