/*
 * @Author: xingpan 
 * @Date: 2022-08-02 11:34:28 
 * @Last Modified by: xingpan
 * @Last Modified time: 2022-08-06 10:15:44
 */

var rotate = function(matrix) {
    // 旋转后的组合规律
    // 1 = 原第二索引
    // 2 = 一位数组长度 - 原第一索引

    if (!Array.isArray(matrix)) {
        throw new Error('this is no a array!!'); 
    }

    const arrayLength = matrix[0].length;
    const newMartrix = new Array(arrayLength).fill(new Array(arrayLength));
    for(let i = 0; i < arrayLength; i++) {
        for(let j = 0; j < arrayLength; j++) {
            // j 制定行
            // arrayLength - i - 1 制定列
            let tempArray = [].concat(newMartrix[j]);
            const index2 = arrayLength - i - 1;

            tempArray.splice(index2, 1, matrix[i][j]);
            newMartrix[j] = tempArray
        }
    }

    return newMartrix;
};

let testArray = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
]

const result = rotate(testArray);
console.log('result', result);