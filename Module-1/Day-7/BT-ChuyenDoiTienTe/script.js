function convertCurrency() {
    let fCurrency = document.getElementById("fromCurrency").value;
    let tCurrency = document.getElementById("toCurrency").value;
    let amount = document.getElementById("amount").value;
    let result;
    if (fCurrency!=tCurrency)
    {
        if (fCurrency=="VND")
            result = amount / 23000;
        else
            result = amount * 23000;
    }
    else
        result = amount;
    document.getElementById("result").innerText = 'Result: ' + result + ' ' + tCurrency;
}