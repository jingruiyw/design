package com.book.mall.leetcode.str;

import java.util.Arrays;

/**
 * ClassName: ValidAnagram
 * Description:
 * 242. 有效的字母异位词
 * date: 2020/7/2 12:38 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ValidAnagram {

    /**
     * 2.哈希表：初始化一个26个字母的哈希表，一个字符串增量，一个字符串减少
     * time:O(n)
     * space:O(1) 表的大小保持不变
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagramV2(String s, String t) {
        //字符长度判断
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        //遍历哈希表是否都为0
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 1.将字符串转字符数组并排序，比较最终结果
     * time:O(nlogn)
     * space:O(1)
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        //字符长度判断
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
