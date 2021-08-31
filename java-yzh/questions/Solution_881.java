package questions;

import java.util.Arrays;

/**
 * @author zhenghai yang
 * @date 2021-08-26
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 */
public class Solution_881 {

    public static void main(String[] args) {
        int[] people = {2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10};
        int[] p1 = {3,2,2,3,2};
        int limit = 50;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int num = 0;
        double half = (double) limit / 2;
        while (start <= end) {
            if (people[end] >= limit) {
                num++;
                end--;
            } else if (people[end] <= half) {
                int count = end - start;
                if (count == 0) {
                    return ++num;
                }
                num = num + count/2 + 1;
                return num;
            } else {
                if (people[start] + people[end] <= limit) {
                    num++;
                    start++;
                    end--;
                } else {
                    end--;
                    num++;
                }
            }
        }
        return num;
    }
}
