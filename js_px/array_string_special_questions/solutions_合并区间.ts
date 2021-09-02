/*
 * @Author: xingpan 
 * @Date: 2021-09-02 16:25:55 
 * @Last Modified by: xingpan
 * @Last Modified time: 2021-09-02 16:27:11
 */

/* 
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

*/

function merge(intervals: number[][]): number[][] {
    if (intervals.length === 1) {
        return intervals;
    }

    let copyIntervals = intervals.sort((a, b) => a[0] - b[0]);
    let result = [];
    for (let i = 0; i < copyIntervals.length;i++) {
        let temp = copyIntervals[i];
        let temp2 = result[result.length - 1];
        if (temp2 && temp[0] <= temp2[1]) {
            if (temp[0] === temp2[1]) {
                temp2 = [temp2[0], temp[1]];
            } else if (temp[0] === temp2[0]) {
                temp2 = temp[1] >= temp2[1] ? temp : temp2;
            } else {
                temp2 = temp[1] >= temp2[1] ? [temp2[0], temp[1]] : temp2;
            }
            result[result.length - 1] = temp2;
        } else {
            result.push(temp);
        };
    }

    return result;
};