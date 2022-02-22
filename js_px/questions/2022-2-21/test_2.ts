// 输入两个正整数的和与差，来确认这个这两个数字。


function getTwoNumber(sum: number, differences: number): string {
    const total = (sum + differences) / 2;

    return `${total} ---- ${total - differences}`;
}

let num1 = 10;
let num2 = 20;

const test_2_result = getTwoNumber(num2, num1);
console.log('result', test_2_result);
