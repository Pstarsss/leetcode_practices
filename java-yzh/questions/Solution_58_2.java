package questions;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class Solution_58_2 {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }

    public static String reverseLeftWords(String s, int n) {
        String[] split = s.split("");
        StringBuilder head = new StringBuilder();
        StringBuilder last = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if(i < n){
                last.append(split[i]);
            }else{
                head.append(split[i]);
            }
        }
        return head.append(last).toString();
    }
}
