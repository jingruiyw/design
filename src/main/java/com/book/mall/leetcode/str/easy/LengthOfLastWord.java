package com.book.mall.leetcode.str.easy;

/**
 * ClassName: LengthOfLastWord
 * Description:
 * 58. 最后一个单词的长度
 * <p>
 * date: 2020/7/13 1:23 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord("Hello World"));
//        System.out.println(lengthOfLastWord("b a  "));
        System.out.println(lengthOfLastWord(" a"));
    }

    /**
     * 从后往前遍历
     *
     * @param s
     * @return
     */
    private static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.trim().equals("")) {
            return 0;
        }
        int count = 0;
        int length = s.trim().length() - 1;

        for (int i = length; i >= 0; i--) {
            String sTrim = s.trim();
            if (sTrim.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
