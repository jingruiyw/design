package com.book.mall.code.str.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LongestPalindrome
 * Description:
 * date: 2020/7/2 1:01 上午
 * 409. 最长回文串
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("asdfg"));
    }

    /**
     * 1.利用set不可重复特点，重复将count*2并移除重复元素
     * time:O(n)
     * space:O(n)
     *
     * @param s
     * @return
     */
    private static int longestPalindrome(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return count;
        }
        Set<Character> set = new HashSet<>();
        for (Character c : chars) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                count = count + 2;
                set.remove(c);
            }
        }
        if (set.size() != 0) {
            count++;
        }
        return count;
    }
}
