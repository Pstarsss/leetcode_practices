package questions;

import java.util.Arrays;

/**
 * @author zhenghai yang
 * @date 2021-08-23
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 *
 */
public class Solution_1646 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(getMaximumGenerated(n));
    }
    public static int getMaximumGenerated(int n){
        if (n < 2){
            return n;
        }
        n++;
        int[] arr = new int[n];
        int max = 0;
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            if ((i & 1) == 0){
                arr[i] = arr[i / 2];

            }else {
                arr[i] = arr[(i - 1) / 2] + arr[(i - 1) / 2 + 1];
            }
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
