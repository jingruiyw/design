package com.book.mall.leetcode.str;

/**
 * ClassName: ImplementStrStr
 * Description:
 * 28. 实现 strStr()
 * date: 2020/7/7 11:45 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }

    /**
     * 1.暴力循环遍历
     * time:O(n)
     * space:O(1)
     *
     * @param haystack
     * @param needle
     * @return
     */
    private static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        if (haystack.equals("")) {
            return -1;
        }

        int left = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) {
                return left;
            }
            String sub = haystack.substring(i, i + needle.length());
            if (sub.equals(needle)) {
                left = i;
                return left;
            }
        }
        return left;
    }
}
