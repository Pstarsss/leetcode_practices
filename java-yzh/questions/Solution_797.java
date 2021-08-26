package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * <p>
 * 示例 1：
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 *
 * @author zhenghai yang
 * @date 2021-08-25
 */
public class Solution_797 {

    public static void main(String[] args) {
        int[][] graph = {{4,3,1}, {3,2,4}, {3}, {4},{}};
        List<List<Integer>> result = allPathsSourceTarget(graph);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(result, path, 0, 0, graph);
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> path, int row, int column, int[][] graph) {
        //终止条件，当graph[row][column] == graph.length - 1 || row >= graph.length - 1
        if (row >= graph.length - 1 || (path.size() > 0 && path.get(path.size() - 1) == graph.length - 1)) {
            if (path.get(path.size() - 1) == graph.length - 1) {
                List<Integer> res = new ArrayList<>();
                path.stream().forEach(p -> res.add(p));
                result.add(res);
            }
            return;
        }

        for (int i = column; i < graph[row].length; i++) {
            path.add(graph[row][i]);
            int count = row;
            row = graph[row][i];
            column = 0;
            dfs(result, path, row, column, graph);
            row = count;
            path.remove(path.size() - 1);
        }
    }
}
