package com.book.mall.leetcode.str.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LongestSubstringWithoutRepeatingCharacters
 * Description:
 * 3. 无重复字符的最长子串
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int lp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer lastIndex = map.get(s.charAt(i));
                //lp取大值，保证max准确性
                lp = Math.max(lp, (lastIndex + 1));
            }
            map.put(s.charAt(i), i);
            if (i - lp + 1 > max) {
                max = i - lp + 1;
            }
        }
        return max;
    }
}
