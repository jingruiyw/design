package com.book.mall.leetcode;

/**
 * ClassName: ReverseString
 * Description:
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * <p>
 * 翻转字符串
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * date: 2020/6/3 1:31 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[] {'h','e','l','l','o'};
        reverseString(s);

        System.out.println(s);
    }

    /**
     * 2.双指针，指针相同则停止交换
     * time: O(n)
     * space:O(1)
     * @param s
     */
    private static void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }


    /**
     * 1.转成数组，中间切一刀再交换两头
     * time:O(n)
     * space:O(1)
     *
     * @param s
     */
    public void reverseString1(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }
}
