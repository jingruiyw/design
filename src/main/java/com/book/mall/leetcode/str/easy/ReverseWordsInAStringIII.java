package com.book.mall.leetcode.str.easy;

/**
 * ClassName: ReverseWordsInAStringIII
 * Description:
 * 557. 反转字符串中的单词 III
 *
 * date: 2020/7/11 1:45 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
//        System.out.println(reverseStr("masd"));
        System.out.println(reverseWords("Let's take LeetCode contest"));

    }

    /**
     * @param s
     * @return
     */
    private static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //分割
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        //翻转 + 拼接
        for (String str : strs) {
            sb.append(reverseStr(str));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 翻转字符串： 可以用StringBuilder的reverse()方法代替
     *
     * @param s
     * @return
     */
    private static String reverseStr(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            char temp = s.charAt(left);
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
