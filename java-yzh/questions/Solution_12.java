package questions;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class Solution_12 {

    Map<Character, List<Pair<Integer,Integer>>> indexMap = new HashMap<>();

    public static void main(String[] args) {
        Solution_12 solution = new Solution_12();
        char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "abcced";
        System.out.println(solution.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<Pair<Integer, Integer>> entryList = indexMap.get(board[i][j]);
                if(null == entryList){
                    entryList = new ArrayList<>();
                    entryList.add(new Pair<>(i,j));
                    indexMap.put(board[i][j],entryList);
                }else {
                    entryList.add(new Pair<>(i,j));
                }
            }
        }

        char[] words = word.toCharArray();

        List<Pair<Integer, Integer>> entryList = indexMap.get(words[0]);
        if(null == entryList){
            return false;
        }
        if(words.length <= 1){
            return true;
        }
        boolean flag = true;
        for (Pair<Integer, Integer> entry : entryList) {
            flag = search(1,words,entry.getKey(),entry.getValue());
        }
        return flag;
    }

    public boolean search(int start,char[] words,int x,int y){
        if(start > words.length - 1){
            return true;
        }
        char word = words[start];
        List<Pair<Integer, Integer>> entryList = indexMap.get(word);
        if(null == entryList){
            return false;
        }
        boolean flag = false;
        for (Pair<Integer, Integer> pair : entryList) {
            if((pair.getKey()==x+1&&pair.getValue()==y) || (pair.getKey()==x&&pair.getValue()==y+1) || (pair.getKey()==x&&pair.getValue()==y-1) || (pair.getKey()==x-1&&pair.getValue()==y)){
                flag = flag || search(start+1,words,pair.getKey(),pair.getValue());
            }else{
                return false;
            }
        }
        return flag;
    }

}
