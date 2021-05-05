function getFibonacci(n: number): number {
    if (n == 1 || n == 2) {
        return 1;
    }
    return getFibonacci(n - 1) + getFibonacci(n - 2);
}

let total = 20;
let sum = 0;
for (let i = 1; i <= total; i++) {
    let fibonacci = getFibonacci(i);
    console.log(fibonacci);
    sum += fibonacci;
}

console.log('Sum: ' + sum);