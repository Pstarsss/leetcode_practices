package questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */

public class Solution_57_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findContinuousSequence(978)));
    }

    public static int[][] findContinuousSequence(int target) {
        int count = 2;
        int flag;
        ArrayList<int[]> list = new ArrayList<>();
        do{
            if(((double)(2*target)/count -count + 1) % 2 == 0){
                flag = ((2*target)/count -count + 1)/2;
                if(flag != 0){
                    list.add(buildInt(flag,count));
                }
            }
            count++;
        }while (count*count-count < 2 * target);
        Collections.reverse(list);
        return list.toArray(new int[0][]);
    }
    private static int[] buildInt(int start,int count){
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = start++;
        }
        return result;
    }
}
