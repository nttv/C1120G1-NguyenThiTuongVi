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
let price, discount, amount;
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
    if(document.getElementById("room1").checked){
        inputRoom = document.getElementById("room1").value;
    }else if(document.getElementById("room2").checked){
        inputRoom = document.getElementById("room2").value;
    }else
        inputRoom = document.getElementById("room3").value;
    console.log(inputCName);
    console.log(inputIdNumber);
    console.log(inputBirthday);
    console.log(inputEmail);
    console.log(inputAddress);
    console.log(inputCity);
    console.log(inputCType);
    console.log(inputNoOfPeople);
    console.log(inputRentDays);
    console.log(inputService);
    console.log(inputRoom);
    // //Displays the saved values on Confirmation form
    // document.getElementById("customerName").innerText=inputCName;
    // inputIdNumber = document.getElementById("inIdNumber").value;
    // inputBirthday = document.getElementById("inBirthday").value;
    // inputEmail = document.getElementById("inEmail").value;
    // inputAddress = document.getElementById("inAddress").value;
    // inputCity = document.getElementById("inCity").innerText;
    // inputCType = document.getElementById("inCustomerType").innerText;
    // inputNoOfPeople = document.getElementById("inNoOfPeople").value;
    // inputRentDays = document.getElementById("inRentDays").value;
    // inputService = document.getElementById("inService").innerText;
    // if(document.getElementById("room1").checked){
    //     inputRoom = document.getElementById("room1").innerText;
}

function edit() {

}

function calDiscount() {

}