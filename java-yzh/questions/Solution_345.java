package questions;

import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * @author zhenghai yang
 * @date 2021-08-19
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = 'hello'
 * 输出：'holle'
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = 'leetcode'
 * 输出：'leotcede'
 */
public class Solution_345 {

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start = 0, end = s.length() - 1;
        char[] split = s.toCharArray();
        while (start < end) {
            if (!isVowel(split[start])) {
                start++;
            }
            if (!isVowel(split[end])) {
                end--;
            }
            if (isVowel(split[start]) && isVowel(split[end])) {
                char medium = split[start];
                split[start] = split[end];
                split[end] = medium;
                start++;
                end--;
            }
        }
        return new String(split);
    }

    public static boolean isVowel(char s) {
        return  s == 'a' || s == 'A' ||
                s == 'e' || s == 'E' ||
                s == 'i' || s == 'I' ||
                s == 'o' || s == 'O' ||
                s == 'u' || s == 'U';
    }

}
