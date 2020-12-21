package com.book.mall.code;

/**
 * ClassName: ReverseInteger
 * Description:
 *
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * date: 2020/6/7 10:09 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class ReverseInteger {

    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(0));
//        System.out.println(reverse(1));
        System.out.println(reverseV2(1534236469));
        System.out.println(reverseV2(-2147483648));


    }


    /**
     * ver.2.0
     * 翻转整数
     *
     * @param x
     * @return
     */
    private static int reverseV2(int x) {

        //1.判断是否是负数 2.负数的最小值，如果是，直接返回0
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        //负数转换符号
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }

        int ret = 0;
        while (x != 0) {
            int n = ret;
            n *= 10;
            n += x % 10;
            x /= 10;

            //3.考虑值溢出问题
            if (n / 10 != ret) {
                return 0;
            }
            ret = n;
        }

        if (flag) {
            return -ret;
        } else {
            return ret;
        }
    }

    /**
     * ver.1.0
     * 翻转整数
     *
     * @param x
     * @return
     */
    private static int reverseV1(int x) {
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }

        long n = 0;
        while (x != 0) {
            n *= 10;
            n += x % 10;
            x /= 10;
        }
        if (n > Integer.MAX_VALUE || -n > Integer.MAX_VALUE) {
            return 0;
        }

        if (flag) {
            return (int) -n;
        } else {
            return (int) n;
        }
    }
}
