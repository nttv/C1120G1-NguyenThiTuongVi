let products = [];
let index;
let tableHeader = "<tr><th id='id'></th><th id='productName'>Product Name</th><th id='totalProducts'></th></tr>";
let product;
window.onload = displayProduct();

function displayProduct() {
    let tableContent = tableHeader;
    for (let i = 0; i < products.length; i++) {
        tableContent += "<tr><td>" + (i + 1) + "</td><td>" + products[i]
            + "</td><td><button type='button'>Edit</button></td>"
            + "<td><button>Delete</button></td></tr>";
    }
    document.getElementById("productsInfo").innerHTML = tableContent;
}

function addProduct() {
    product = document.getElementById("input").value;
    if (product != "") {
        products.push(product);
        document.getElementById("input").value = "";
    } else
        alert("Bạn chưa nhập tên sản phẩm");
    displayProduct();
}

function editProduct() {

}

function deleteProduct() {

}