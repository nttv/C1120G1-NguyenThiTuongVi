let inputCName //= document.getElementById("inCustomerName").value;
let inputIdNumber //= document.getElementById("inIdNumber").value;
let inputBirthday //= document.getElementById("inBirthday").value;
let inputEmail //= document.getElementById("inEmail").value;
let inputAddress //= document.getElementById("inAddress").value;
let inputCity //= document.getElementById("inCity").innerText;
let inputCType //= document.getElementById("inCustomerType").innerText;
let inputNoOfPeople //= document.getElementById("inNoOfPeople").value;
let inputRentDays //= document.getElementById("inRentDays").value;
let inputService //= document.getElementById("inService").innerText;
let inputRoom;
let price, discount, amount = 0;
// if(document.getElementById("room1").checked){
//     inputRoom = document.getElementById("room1").innerText;
// }else if(document.getElementById("room2").checked){
//     inputRoom = document.getElementById("room2").innerText;
// }else
//     inputRoom = document.getElementById("room3").innerText;


window.onload = init();

function init() {
    //Only show initialization with Reservation form
    document.getElementById("confirmation").style.display = "none";
    document.getElementById("back").style.display = "none";
    document.getElementById("confirm").style.display = "none";
}

function reserve() {
    //Revert from Reservation form to Confirmation form
    document.getElementById("reservation").style.display = "none";
    document.getElementById("reserve").style.display = "none";
    document.getElementById("confirmation").style.display = "initial";
    document.getElementById("back").style.display = "initial";
    document.getElementById("confirm").style.display = "initial";

    //Save entered values
    inputCName = document.getElementById("inCustomerName").value;
    inputIdNumber = document.getElementById("inIdNumber").value;
    inputBirthday = document.getElementById("inBirthday").value;
    inputEmail = document.getElementById("inEmail").value;
    inputAddress = document.getElementById("inAddress").value;
    inputCity = document.getElementById("inCity").value;
    inputCType = document.getElementById("inCustomerType").value;
    inputNoOfPeople = document.getElementById("inNoOfPeople").value;
    inputRentDays = document.getElementById("inRentDays").value;
    inputService = document.getElementById("inService").value;
    if (document.getElementById("room1").checked) {
        inputRoom = document.getElementById("room1").value;
    } else if (document.getElementById("room2").checked) {
        inputRoom = document.getElementById("room2").value;
    } else
        inputRoom = document.getElementById("room3").value;

    calDiscount();
    calAmount();

    //Displays the saved values on Confirmation form
    document.getElementById("customerName").innerText = inputCName;
    document.getElementById("idNumber").innerText = inputIdNumber;
    document.getElementById("birthday").innerText = inputBirthday;
    document.getElementById("email").innerText = inputEmail;
    document.getElementById("address").innerText = inputAddress + ", " + inputCity;
    document.getElementById("customerType").innerText = inputCType;
    document.getElementById("noOfPeople").innerText = inputNoOfPeople;
    document.getElementById("rentDays").innerText = inputRentDays;
    document.getElementById("service").innerText = inputService;
    document.getElementById("room").innerText = inputRoom;
    document.getElementById("discount").innerText = Math.round(discount) + "%";
    document.getElementById("amount").innerText = "$" + Math.round(amount);
}

function edit() {
    document.getElementById("confirmation").style.display = "none";
    document.getElementById("back").style.display = "none";
    document.getElementById("confirm").style.display = "none";
    document.getElementById("reservation").style.display = "initial";
    document.getElementById("reserve").style.display = "initial";
}

function calDiscount() {
    discount = 0;
    switch (inputCity) {
        case "Đà Nẵng":
            discount += 20;
            break;
        case "Huế":
            discount += 10;
            break;
        case "Quảng Nam":
            discount += 5;
            break;
    }
    switch (inputCType) {
        case "Diamond":
            discount += 15;
            break;
        case "Platinum":
            discount += 10;
            break;
        case "Gold":
            discount += 5;
            break;
        case "Silver":
            discount += 2;
            break;
    }
    if (inputRentDays > 7) {
        discount += 30;
    } else if (inputRentDays >= 5) {
        discount += 20;
    } else if (inputRentDays >= 2) {
        discount += 10;
    }
}

function calAmount() {
    if (inputService == "Villa") {
        price = 500;
    } else if (inputService == "House") {
        price = 300;
    }
    if (inputService == "Room") {
        price = 100;
    }
    amount = price * inputRentDays * (1 - discount / 100);
}