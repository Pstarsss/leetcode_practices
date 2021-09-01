/*
 * @Author: xingpan 
 * @Date: 2021-09-01 19:53:16 
 * @Last Modified by:   xingpan 
 * @Last Modified time: 2021-09-01 19:53:16 
 */
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

*/

function searchInsert(nums: number[], target: number): number {
    let len = nums.length;
    for (let i = 0;i < len; i++) {
         if(target <= nums[i]){
            return i;
        }
    }
    return len;
};