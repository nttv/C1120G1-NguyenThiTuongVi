function getFibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    return getFibonacci(n - 1) + getFibonacci(n - 2);
}
var total = 20;
var sum = 0;
for (var i = 1; i <= total; i++) {
    var fibonacci = getFibonacci(i);
    console.log(fibonacci);
    sum += fibonacci;
}
console.log('Sum: ' + sum);
