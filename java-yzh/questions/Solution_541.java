package questions;

/**
 * @author zhenghai yang
 * @date 2021-08-20
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 */
public class Solution_541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }

    public static String reverseStr(String s, int k) {
        if (s.length() <= 1){
            return s;
        }
        char[] chs = s.toCharArray();
        int length = chs.length;
        int start = 0,end = 0;
        while(end < length){
           end += 2 * k;
           if (end < length){
               rever(chs,start,start+k);
               start = end;
           }else {
               if (end - length <= k){
                   rever(chs,start,start+k);
               }else {
                   rever(chs,start,length);
               }
               return new String(chs);
           }
        }
        return new String(chs);
    }

    public static void rever(char[] chs,int start,int end){
        end = end -1 ;
        while(start<=end){
            char ch = chs[start];
            chs[start] = chs[end];
            chs[end] = ch;
            start++;
            end--;
        }
    }
}
