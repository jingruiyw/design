package com.book.mall.code.str.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: FirstUniqueCharacterInAString
 * Description:
 * <p>
 * 387. 字符串中的第一个唯一字符
 * date: 2020/7/11 1:14 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
//        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    /**
     * 1.利用散列表遍历一次记录每个字符出现次数
     *   再按顺序取第一个次数为1的下标
     * @param s
     * @return
     */
    private static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
