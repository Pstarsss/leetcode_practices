// 输入两个正整数的和与差，来确认这个这两个数字。
function getTwoNumber(sum, differences) {
    var total = (sum + differences) / 2;
    return total + " ---- " + (total - differences);
}
var num1 = 10;
var num2 = 20;
var test_2_result = getTwoNumber(num2, num1);
console.log('result', test_2_result);
