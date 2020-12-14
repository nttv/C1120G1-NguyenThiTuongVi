let inputCName;
let inputIdNumber;
let inputBirthday;
let inputEmail;
let inputAddress;
let inputCity;
let inputCType;
let inputNoOfPeople;
let inputRentDays;
let inputService;
let inputRoom;
let price, discount, amount = 0;

window.onload = init();

function init() {
    //Only show initialization with Add Customer form
    document.getElementById("customer-info").style.display = "none";
    document.getElementById("edit").style.display = "none";
}

function addCustomer() {
    //Revert from Reservation form to Customer Info form
    document.getElementById("add-customer").style.display = "none";
    document.getElementById("add").style.display = "none";
    document.getElementById("customer-info").style.display = "initial";
    document.getElementById("edit").style.display = "initial";

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

    //Displays the saved values on Customer Info form
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

function editCustomer() {
    document.getElementById("customer-info").style.display = "none";
    document.getElementById("edit").style.display = "none";
    document.getElementById("add-customer").style.display = "initial";
    document.getElementById("add").style.display = "initial";
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