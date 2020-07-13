package com.book.mall.leetcode.str.easy;


/**
 * ClassName: LongestCommonPrefix
 * Description:
 * 14. 最长公共前缀
 * date: 2020/7/7 2:09 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 1.暴力循环
     * time: O(n)
     * space:O(1)
     *
     * @param strs
     * @return
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
