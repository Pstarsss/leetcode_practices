package questions;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */

public class Solution_57 {

    public static void main(String[] args) {
        Solution_57 solution = new Solution_57();
        int[] nums = {10,26,30,31,47,60};
        System.out.println(Arrays.toString(solution.twoSum(nums, 40)));
    }

    public int[] twoSum(int[] nums, int target) {
        int first = 0;
        int last =  nums.length - 1;
        //注意数组越界问题
        while (first < last) {
            if (nums[(last + first) / 2] < target) {
                break;
            }
            last = (last + first) / 2;
        }
        return searchSum(first, last, nums, target);
    }

    public int[] searchSum(int first, int last, int[] nums, int target) {
        int[] result = new int[2];
        while (first <= last) {
            if (nums[first] + nums[last] == target) {
                result[0] = nums[first];
                result[1] = nums[last];
                return result;
            } else if (nums[first] + nums[last] > target) {
                last--;
            } else {
                first++;
            }
        }
        return result;
    }
}
