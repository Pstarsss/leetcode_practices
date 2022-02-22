// 输入一个数字正整数数字， 求出第一个大于它的回文数 数字。

function isReverseNumber(num: number): boolean{
    const num1 = num.toString().split('').join('');
    const num2 = num.toString().split('').reverse().join('');
    return num1 === num2;
}


function firstReverseNumber(num: number): number {
    let flag = true;
    let tempNum = num;
    while (flag) {
        tempNum += 1;
        if (isReverseNumber(tempNum)) {
            flag = false;
        }
    };

    return tempNum;
}



let temp = 818;
let result = firstReverseNumber(temp);
console.log('result', result);