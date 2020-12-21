package com.book.mall.code.doublePoint;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: ReverseVowelsOfAString
 * Description:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * <p>
 * date: 2020/6/12 12:41 上午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
//        System.out.println(reverseVowels("q"));
//        System.out.println(reverseVowels("hello"));
//        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels1("hello"));
        System.out.println(reverseVowels1("leetcode"));

    }


    /**
     * 其他题解：双指针
     *
     * @param s
     * @return
     */
    public static String reverseVowels1(String s) {
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    /**
     * 双指针
     * time：O(n)
     * space：O(1)
     *
     * @param s
     * @return
     */
    private static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return s;
        }
        //元音集合
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int left = 0;
        int right = chars.length - 1;
        Character leftChar = null;
        Character rightChar = null;
        while (left < right) {
            if (vowels.contains(chars[left])) {
                leftChar = chars[left];
            } else {
                left++;
            }
            if (vowels.contains(chars[right])) {
                rightChar = chars[right];
            } else {
                right--;
            }
            if (leftChar != null && rightChar != null) {
                chars[left] = rightChar;
                chars[right] = leftChar;
                leftChar = null;
                rightChar = null;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
