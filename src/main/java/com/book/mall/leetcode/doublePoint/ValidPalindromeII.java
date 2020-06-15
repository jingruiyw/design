package com.book.mall.leetcode.doublePoint;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ValidPalindromeII
 * Description:
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * <p>
 * date: 2020/6/14 1:37 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("deeee"));
        System.out.println(validPalindrome("eeeed"));
        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
    }

    /**
     * 双指针：两边不等后，删除一个分别判断左右删除后的子串是否是回文串
     * time:O(n) 遍历所有字符
     * space:O(1)
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    /**
     * 判断字符串是否是回文串
     * time：O(n)
     * space：O(1)
     *
     * @param s
     * @param i
     * @param j
     * @return
     */
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
