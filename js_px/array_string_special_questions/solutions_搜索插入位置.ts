/*
 * @Author: xingpan 
 * @Date: 2021-09-01 19:53:16 
 * @Last Modified by: xingpan
 * @Last Modified time: 2022-06-23 13:56:57
 */
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。 二分法吧

*/
// 暴力解法 时间复杂度 O(N);
function searchInsert(nums: number[], target: number): number {
    let len = nums.length;
    for (let i = 0;i < len; i++) {
         if(target <= nums[i]){
            return i;
        }
    }
    return len;
};

function searchInsert2(nums: number[], target: number): number {
    let left = 0;
    let right = nums.length - 1;
    while (left <= right) {
        let mid = left + (right - left) >> 1;
        if (nums[mid] === target) {
            return mid;
        } 
        
        if (nums[mid] > target) {
            right = mid - 1;
        } 
        
        if (nums[mid] < target) {
            left = mid + 1;
        }
    }

    return left;
}   