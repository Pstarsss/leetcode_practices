// 输入一个数字正整数数字， 求出第一个大于它的回文数 数字。
function isReverseNumber(num) {
    var num1 = num.toString().split('');
    var num2 = num.toString().split('').reverse();
    return num1.join('') === num2.join('');
}
function firstReverseNumber(num) {
    var flag = true;
    var tempNum = num;
    while (flag) {
        tempNum += 1;
        if (isReverseNumber(tempNum)) {
            flag = false;
        }
    }
    ;
    return tempNum;
}
var temp = 818;
var result = firstReverseNumber(temp);
console.log('result', result);
