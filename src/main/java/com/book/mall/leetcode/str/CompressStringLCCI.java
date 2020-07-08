package com.book.mall.leetcode.str;


import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CompressStringLCCI
 * Description:
 * 面试题 01.06. 字符串压缩
 * date: 2020/7/9 12:05 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class CompressStringLCCI {

    public static void main(String[] args) {
//        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressStringV2("aabcccccaaa"));
    }

    private static String compressStringV2(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        S = S + "*";
        StringBuilder sb = new StringBuilder(S.charAt(0));
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                sb.append(S.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }
        S = S.substring(0, S.length() - 1);
        if (sb.length() < S.length()) {
            return sb.toString();
        }
        return S;
    }

    /**
     * 1.一次遍历数量，一次写出字符串
     * time:O(n)
     * space:O(n)
     *
     * @param S
     * @return
     */
    private static String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        S = S + "*";
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        Character temp = S.charAt(0);
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (i >= 1 && S.charAt(i - 1) != S.charAt(i)) {
                sb.append(S.charAt(i - 1));
                sb.append(map.get(S.charAt(i - 1)));
            }

            if (map.containsKey(c) && temp.equals(c)) {
                map.put(c, map.get(c) + 1);
            } else if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.remove(c);
                map.put(c, 1);
            }
            temp = c;
        }
        S = S.substring(0, S.length() - 1);
        if (sb.length() < S.length()) {
            return sb.toString();
        }
        return S;
    }
}
