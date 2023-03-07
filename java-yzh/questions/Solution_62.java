package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class Solution_62 {

    public static void main(String[] args) {
        Solution_62 solution = new Solution_62();
        int luck = solution.lastRemaining(5, 3);
        System.out.println(luck);
    }

    public int lastRemaining(int n, int m) {
        if(n == 1){
            return n;
        }
        List<Integer> array = buildArray(n);
        int index = 0;
        do{
            int step = (index + m - 1) % array.size();
            array.remove(step);
            index = step ;
        }while (array.size() > 1);
        return array.get(0);
    }

    public List<Integer> buildArray(int n){
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }
        return array;
    }
}
