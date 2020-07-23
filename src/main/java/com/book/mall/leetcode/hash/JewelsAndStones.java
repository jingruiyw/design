package com.book.mall.leetcode.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: JewelsAndStones
 * Description:
 * 771. 宝石与石头
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * <p>
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头
 * <p>
 * date: 2020/7/24 12:54 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    /**
     * 遍历两个字符串，丢进set看最终种类
     *
     * @param J
     * @param S
     * @return
     */
    private static int numJewelsInStones(String J, String S) {

        char[] jChars = J.toCharArray();
        char[] sChars = S.toCharArray();

        Set<Character> set = new HashSet<>();
        for (Character c : jChars) {
            set.add(c);
        }

        List<Character> result = new ArrayList<>();
        for (Character c : sChars) {
            if (set.contains(c)) {
                result.add(c);
            }
        }
        return result.size();
    }
}
