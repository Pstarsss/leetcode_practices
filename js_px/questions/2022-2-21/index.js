/*
 * @Author: xingpan 
 * @Date: 2022-02-23 18:55:54 
 * @Last Modified by:   xingpan 
 * @Last Modified time: 2022-02-23 18:55:54 
 */

// 输入一个正整数 数字n，
// 在输入一组数量为n个的任意数值， 然后求出这组数值组成的最大值
// 例如： 3 / [13, 312, 343]  => 34331213
// 例如： 4 / [7, 13, 4, 246] => 7424613

// [7, 4, 246, 13]
// [343, 312, 13]
function getMaxNumber(quantity, arr) {
    if (!quantity) {
        return ;
    }

    return arr.sort((a, b) => {
        let tempA = a.toString().split(''); // 312
        let tempB = b.toString().split(''); // 342
        const index = tempA.findIndex((item, index) => item > (tempB[index] || Number.MAX_VALUE));
        if (index !== - 1) {
            return -1;
        }   
        return 1;
    }).join('');
}

const index_result = getMaxNumber(3, [13, 312, 343]);
const index_result1 = getMaxNumber(4, [7, 13, 4, 246]);

console.log('index_result', index_result);
console.log('index_result1', index_result1);
