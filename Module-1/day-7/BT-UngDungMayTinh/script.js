function calculator(operator) {
    let a_num = parseFloat(document.getElementById("a").value);
    let b_num = parseFloat(document.getElementById("b").value);
    let result;
    let operatorName;
    switch (operator) {
        case "+":
            result = a_num + b_num;
            operatorName = "Addition";
            break;
        case "-":
            result = a_num - b_num;
            operatorName = "Subtraction";
            break;
        case "*":
            result = a_num * b_num;
            operatorName = "Multiplication";
            break;
        case "/":
            result = a_num / b_num;
            operatorName = "Division";
            break;
    }
    document.getElementById("result").innerText = "Result " + operatorName + ": " + result;
}