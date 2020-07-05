package com.book.mall.leetcode.str;

import com.book.mall.leetcode.bean.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: IsomorphicStrings
 * Description:
 * 205. 同构字符串
 * <p>
 * date: 2020/7/5 10:58 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
//        System.out.println(isIsomorphic("aaa", "aab"));
        System.out.println(isIsomorphicV2("aaa", "aab"));
    }

    /**
     * 2.将两个数组都转成第三个字符（类似统一格式，转的一样就为true）
     * time: O(n)
     * space: O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphicV2(String s, String t) {
        //界限值判断
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        //长度判断
        if (s.length() != t.length()) {
            return false;
        }
        return change2SameFormat(s).equals(change2SameFormat(t));
    }

    /**
     * 转换
     *
     * @param s
     * @return
     */
    private static String change2SameFormat(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                map.put(c, count);
                count++;
            }
        }
        return sb.toString();
    }


    /**
     * 1.两边都互相转换一下
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        //界限值判断
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        //长度判断
        if (s.length() != t.length()) {
            return false;
        }
        return isTrue(s, t) && isTrue(t, s);
    }

    /**
     * 内部使用方法，直接匹配
     * time:O(n)
     * space:O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isTrue(String s, String t) {
        //转换，匹配
        Map<Character, Character> chars = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (chars.containsKey(c1)) {
                if (!chars.get(c1).equals(c2)) {
                    return false;
                }
            } else {
                chars.put(c1, c2);
            }
        }
        return true;
    }
}
