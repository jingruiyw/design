package com.book.mall.code.str.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ValidPalindrome
 * Description:
 * 125.验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * date: 2020/7/1 12:00 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ValidPalindrome {

    private static boolean isPalindrome1(String s) {
        // 判断长度
        if (s == null || s.length() == 0) {
            return true;
        }
        //将字符串转成字符合集,去掉空格和标点,忽略大小写
        List<Character> characters = new ArrayList<>();
        for (Character character : s.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                characters.add(Character.toLowerCase(character));
            }
        }

        if (characters.size() <= 1) {
            return true;
        }

        //声明两个指针
        int fp = 0;
        int sp = characters.size() - 1;
        while (fp < sp) {
            Character fpc = characters.get(fp);
            Character spc = characters.get(sp);
            if (!fpc.equals(spc)) {
                return false;
            }
            fp++;
            sp--;
        }
        return true;
    }

    /**
     * 1.双指针
     * time:O(n)
     * space:O(n)
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) {
            return true;
        }
        List<Character> characters = new ArrayList<>();
        //转成字符集合
        for (Character c : charArray) {
            if (Character.isLetterOrDigit(c)) {
                characters.add(Character.toLowerCase(c));
            }
        }
        if (characters.size() == 0) {
            return true;
        }
        //双指针比较
        int start = 0;
        int end = characters.size() - 1;
        while (start < end) {
            if (!characters.get(start).equals(characters.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
