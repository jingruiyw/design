package com.book.mall.leetcode;

/**
 * ClassName: PalindromeNumber
 * Description:
 * date: 2020/6/6 11:48 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12345));
        System.out.println(isPalindrome(123454321));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(9));
        System.out.println(isPalindrome(10));
    }

    /**
     * 判断数字是否是回文数
     *
     * @param x
     * @return
     */
    private static boolean isPalindrome(int x) {
        //负数不是回文数，10的整数倍
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int n = 0;

        //要把0结尾的特殊过滤掉，否则转换过来0会被消除掉
        while (n < x) {
            n *= 10;
            n += x % 10;  //把数据从x移到n
            x /= 10; //把原数据减少一位
        }
        //n/10 == x 个位数时 12321
        return (n == x) || (n / 10 == x);
    }
}
